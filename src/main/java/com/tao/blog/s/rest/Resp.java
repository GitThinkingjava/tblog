package com.tao.blog.s.rest;

import java.util.Date;

/**
 *  Rest 返回工具
 * 
 * @author tao
 *
 */
public class Resp {

	private static ReturnRest<Object> msg = ReturnRest.get();

	// 成功
	public static String SUCCESS = "200";
	// 错误,失败
	public static String ERROR = "300";
	// 参数错误
	public static String ERROR_PARAMETER = "400";
	// 程序出错
	public static String ERROR_PROGRAM = "500";
	// 登陆错误,或超时
	public static String ERROR_NO_LOGIN_OR_TIMEOUT = "0004";

	public static String ERROR_EXIST_OPERATION = "0005";

	/**
	 * 成功返回结果
	 * 
	 * @param object 要返回的对象
	 * @return
	 */
	public static ReturnRest<Object> success(Object object) {
		msg.setTime(new Date());
		msg.setCode(SUCCESS);
		msg.setMsg("请求成功");
		msg.setData(object);
		return msg;
	}

	/**
	 * 成功返回结果
	 * 
	 * @param object  要返回的对象
	 * @param message 自定义消息
	 * @return
	 */
	public static ReturnRest<Object> success(Object object, String message) {
		msg.setTime(new Date());
		msg.setCode(SUCCESS);
		msg.setMsg(message);
		msg.setData(object);
		return msg;
	}

	/**
	 * 成功返回
	 * 
	 * @return null
	 */
	public static ReturnRest<Object> success() {
		return success(null);
	}

	/**
	 * 错误的请求
	 * 
	 * @param code     状态码
	 * @param resulMsg 返回的错误消息
	 * @return
	 */
	public static ReturnRest<Object> error(String code) {
		msg.setCode(code);
		msg.setMsg("请求错误");
		return msg;
	}

	/**
	 * 错误的请求
	 * 
	 * @param code     状态码
	 * @param resulMsg 返回的错误消息
	 * @return
	 */
	public static ReturnRest<Object> error(String code, String resulMsg) {
		msg.setCode(code);
		msg.setMsg(resulMsg);
		return msg;
	}

}
