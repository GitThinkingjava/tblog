package com.tao.blog.s.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

/**
 *  Rest 返回工具
 * 
 * @author tao
 *
 */
public class Resp {

	private static ReturnRest<Object> respRest = ReturnRest.get();

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

	public static final String DEFAULT_VALUE= "";

	/**
	 * 成功返回
	 *
	 * @return null
	 */
	public static ReturnRest<Object> success() {
		return success(DEFAULT_VALUE,DEFAULT_VALUE);
	}

	/**
	 * 成功返回
	 *	@param msg  要返回的信息
	 * @return null
	 */
	public static ReturnRest<Object> success(String msg) {
		return success(DEFAULT_VALUE,msg);
	}

	/**
	 * 成功返回结果
	 * 
	 * @param object 要返回的对象
	 * @return
	 */
	public static ReturnRest<Object> success(Object object) {
		respRest.setTime(new Date());
		respRest.setCode(SUCCESS);
		respRest.setMsg("请求成功");
		respRest.setData(object);
		return respRest;
	}

	/**
	 * 成功返回结果
	 * 
	 * @param object  要返回的对象
	 * @param message 自定义消息
	 * @return
	 */
	public static ReturnRest<Object> success(Object object, String message) {
		respRest.setTime(new Date());
		respRest.setCode(SUCCESS);
		respRest.setMsg(message);
		respRest.setData(object);
		return respRest;
	}

	/**
	 * 错误的请求
	 * 
	 * @param code     状态码
	 * @param resulMsg 返回的错误消息
	 * @return
	 */
	public static ReturnRest<Object> error(String code) {
		respRest.setCode(code);
		respRest.setMsg("请求错误");
		return respRest;
	}

	/**
	 * 错误的请求
	 * 
	 * @param code     状态码
	 * @param resulMsg 返回的错误消息
	 * @return
	 */
	public static ReturnRest<Object> error(String code, String resulMsg) {
		respRest.setCode(code);
		respRest.setMsg(resulMsg);
		return respRest;
	}

	public String toJsonString(){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		return gson.toJson(this);
	}

}
