package com.tao.blog.u.article.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * article
 * 
 * @author
 */
@Data
public class Article implements Serializable {

	/**
	 * 实现序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer ariticleId;

	/**
	 * 文章标题
	 */
	private String title;

	/**
	 * 文章简介
	 */
	private String summary;

	/**
	 * 文章作者
	 */
	private String author;

	/**
	 * 文章内容
	 */
	private String content;

	/**
	 * 文章状态
	 */
	private String status;

	/**
	 * 文章关键字
	 */
	private String articleKey;

	/**
	 * 文章是否置顶，0为否，1为是
	 */
	private Integer isTop;

	/**
	 * 文章访问量
	 */
	private Integer traffic;

	/**
	 * 点赞次数
	 */
	private Integer likesNum;

	/**
	 * 文章评价外键
	 */
	private Integer evaluateId;

	/**
	 * 文章类别外键
	 */
	private Integer categoryId;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	/**
	 * 创建用户
	 */
	private String createUser;

	/**
	 * 修改日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date modifiedTime;

	/**
	 * 修改用户
	 */
	private String modifiedUser;

}