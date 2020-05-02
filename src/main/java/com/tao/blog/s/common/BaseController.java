package com.tao.blog.s.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.tao.blog.u.users.model.Users;

public abstract class BaseController {

	/**
	 * 获取用户信息
	 */
	public static final String SESSION_USER = "USERS";

	/**
	 * 需要实现的模块路径
	 * 
	 * @return
	 */
	public abstract String getModulePath();

	/**
	 * 返回页面
	 */
	private String returnView = getModulePath() + "/";

	/**
	 * 转发视图
	 * 
	 * @param view
	 * @return
	 */
	public String view(String view) {
		return returnView + view;
	}

	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView() {
		return new ModelAndView();
	}

	/**
	 * 得到request对象
	 * 
	 * @since 1.0.0.0
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	/**
	 * 
	 * @param key 键
	 * @param obj 值
	 */
	public void setReqAttr(String key, Object obj) {
		getRequest().setAttribute(key, obj);
	}

	/**
	 * 得到response对象
	 */
	public HttpServletResponse getResponse() {
		HttpServletResponse response = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
		return response;
	}

	/**
	 * 得到session对象
	 */
	public HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

	/**
	 * 
	 * @param key 键
	 * @param obj 值
	 */
	public void setSession(String key, Object obj) {
		getSession().setAttribute(key, obj);
	}

	/**
	 * 设置用户登录
	 * 
	 * @param users
	 */
	public void setUserLogin(Users users) {
		getSession().setAttribute(SESSION_USER, users);
	}

	/**
	 * 获取用户信息
	 * 
	 * @param users
	 */
	public Users getUserInfo() {
		return (Users) getSession().getAttribute(SESSION_USER);
	}

}
