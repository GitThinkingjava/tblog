package com.tao.blog.u.article.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * article_category 
 *  文章类型 
 * @author Tangtao
 */
@Data
public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 类别编号
	 */
	private Integer categoryId;

	/**
	 * 类别名称
	 */
	private String categoryName;

	/**
	 * 文章id
	 */
	private Integer articleId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date modifiedTime;

}