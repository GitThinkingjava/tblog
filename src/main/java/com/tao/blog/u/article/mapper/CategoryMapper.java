package com.tao.blog.u.article.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tao.blog.s.common.BaseDao;
import com.tao.blog.u.article.model.Category;

/**
 * ArticleCategoryDAO继承基类
 */
@Mapper
public interface CategoryMapper extends BaseDao<Category> {

}