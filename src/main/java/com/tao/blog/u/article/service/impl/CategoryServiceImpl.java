package com.tao.blog.u.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tao.blog.s.common.BaseServiceImpl;
import com.tao.blog.u.article.mapper.CategoryMapper;
import com.tao.blog.u.article.model.Category;
import com.tao.blog.u.article.service.ICategoryService;

@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements ICategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public List<Category> queryAll(Category t) {
		return categoryMapper.queryAll(t);
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public Category queryById(String id) {
		// TODO Auto-generated method stub
		return super.queryById(id);
	}
}
