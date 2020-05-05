package com.tao.blog.s.aop;

import com.tao.blog.s.annotation.ApiIdempotent;
import com.tao.blog.s.annotation.ApiToken;
import com.tao.blog.s.constants.Constant;
import com.tao.blog.s.rest.Resp;
import com.tao.blog.s.utils.GsonUtil;
import com.tao.blog.s.utils.RedisToken;
import com.tao.blog.s.utils.ServletUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Aop 处理防止重复提交问题
 */
@Aspect
@Component
public class ApiIdempotentAop {

    @Autowired
    private RedisToken redisToken;

    // 1.使用AOP环绕通知拦截所有访问（controller）
    //@Pointcut("execution(* com.tao.blog.*.*.controller.*.*(..))")
    @Pointcut("execution(public * com.tao.blog.u.users.controller.*.*(..))")
    public  void rlAop(){

    }

    // 前置通知
    @Before("rlAop()")
    public void before(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        ApiToken extApiToken = signature.getMethod().getDeclaredAnnotation(ApiToken.class);
        if (extApiToken != null) {
            // 可以放入到AOP代码 前置通知
          ServletUtil.getRequest().setAttribute("token", redisToken.setToken());
        }
    }

    // 环绕通知
    @Around("rlAop()")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 2.判断方法上是否有加ExtApiIdempotent
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        ApiIdempotent declaredAnnotation = methodSignature.getMethod().getDeclaredAnnotation(ApiIdempotent.class);
        // 3.如何方法上有加上ExtApiIdempotent
        if (declaredAnnotation != null) {
            String type = declaredAnnotation.type();
            // 如何使用Token 解决幂等性
            // 步骤：
            String token = null;
            HttpServletRequest request = ServletUtil.getRequest();
            if (type.equals(Constant.API_HEAD)) {
              //  token = request.getHeader("token");
                token = request.getParameter("token");
            }

            if (StringUtils.isEmpty(token)) {
               // return "参数错误";
              //  System.out.println("参数错误！");

                ServletUtil.response(GsonUtil.GsonString(Resp.error(Resp.ERROR_PARAMETER,"参数错误!！")));

                return  null;
            }
            // 3.接口获取对应的令牌,如果能够获取该(从redis获取令牌)令牌(将当前令牌删除掉) 就直接执行该访问的业务逻辑
            boolean isToken = redisToken.findToken(token);
            System.out.println("isToken == " +isToken);
            // 4.接口获取对应的令牌,如果获取不到该令牌 直接返回请勿重复提交
            if (!isToken) {
                System.out.println("response == " +Resp.error(Resp.ERROR,"请勿重复提交").toString());
                ServletUtil.response(GsonUtil.GsonString(Resp.error(Resp.ERROR,"请勿重复提交").toString()));
                // 后面方法不在继续执行
                return null;
            }

        }
        // 放行
        Object proceed = proceedingJoinPoint.proceed();
        return proceed;
    }

}
