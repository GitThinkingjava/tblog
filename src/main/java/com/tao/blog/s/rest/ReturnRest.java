package com.tao.blog.s.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReturnRest<T> {

	/**
	 * 返回系统时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;

	/**
	 * 返回的状态
	 */
	private String code;

	/**
	 * 信息
	 */
	private String msg;

	/**
	 * 返回 data
	 */
	private T data;

	private ReturnRest() {
	}

	private static ReturnRest<?> singleton;

	@SuppressWarnings("unchecked")
	public static synchronized ReturnRest<Object> get() {
		if (singleton == null) {
			singleton = new ReturnRest<Object>();
		}
		return (ReturnRest<Object>) singleton;
	}

}
