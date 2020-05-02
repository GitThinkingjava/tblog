package com.tao.blog.u.article.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 文章的评论
 * 
 * @author
 */
@Data
public class Comments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 评论 id
	 */
	private Integer id;
	/**
	 * 对应文章ID
	 */
	private Long articleId;

	/**
	 * 评论内容
	 */
	private String content;

	/**
	 * 评论用户
	 */
	private Integer userId;

	/**
	 * 评论ip 地址
	 */
	private String ip;

	/**
	 * 评论mac 地址
	 */
	private String macAddre;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

}