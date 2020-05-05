package com.tao.blog.u.mgr.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tao.blog.u.users.model.Users;
import org.apache.logging.log4j.core.tools.picocli.CommandLine.Command;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tao.blog.s.annotation.LoginCheck;
import com.tao.blog.s.common.BaseController;

import lombok.extern.log4j.Log4j2;

/**
 * 后台管理登录验证拦截
 * 
 * @author tao
 *
 */

@Log4j2
@Command
public class LoginInterceptor implements HandlerInterceptor {

	private String page = "mgr/login";
	/**
	 * 该方法将在请求处理之前进行调用，只有该方法返回true， 才会继续执行后续的Interceptor和Controller。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("请求地址 ：" + request.getRequestURI());
		if (handler instanceof HandlerMethod) { // 做判断 2 不处理，因为请求的资源不存在
			Users users = (Users) request.getSession().getAttribute(BaseController.SESSION_USER);
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			// 如果验证token失败，并且方法注明了Authorization，返回Session已失效
			if (method.getAnnotation(LoginCheck.class) != null // 查看方法上是否有注解
					|| handlerMethod.getBeanType().getAnnotation(LoginCheck.class) != null) { // 查看方法所在的Controller是否有注解
				if (null == users) {
					log.info("未登录 重定向到登录页面!");
					response.sendRedirect("../mgr/login");
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用， 可以在这个方法中对Controller
	 * 处理之后的ModelAndView 对象进行操作。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception {
		// model.setViewName(page);
		//log.info("postHandle...");
	}

	/**
	 * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行， 该方法将在整个请求结束之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//log.info("afterCompletion...");
	}

}
