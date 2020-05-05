package com.tao.blog.s.utils;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** 返回HttpServletRequest对象和HttpServletResponse对象
 * @author tangtao
 * @date 2019-04-10
 * */
public class  ServletUtil {


    /** 返回一个HttpServletRequest
     * @return request请求体
     * */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }

    /** 返回一个HttpServletResponse
     * @return response响应流
     * */
    public static HttpServletResponse getResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 响应消息
     * @param msg
     * @throws IOException
     */
    public static void response(String msg) throws IOException {
        HttpServletResponse response = getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            writer.println(msg);
        } catch (Exception e) {

        } finally {
            writer.close();
        }
    }

}
