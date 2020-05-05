package com.tao.blog.u.users.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * users 
 * 
 * @author
 */
@Data
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 登录ip
	 */
	private String loginIp;

	/**
	 * 密码
	 */
	private String passwd;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 头像照片
	 */
	private String profilePhoto;

	/**
	 * 级别
	 */
	private String level;

	/**
	 * 权限
	 */
	private String rights;

	/**
	 * 年龄
	 */
	private String age;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 注册时间
	 */
	private Date registrationTime;


}