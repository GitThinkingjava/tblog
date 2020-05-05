package com.tao.blog.u.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tao.blog.s.common.BaseServiceImpl;
import com.tao.blog.u.article.mapper.ArticleMapper;
import com.tao.blog.u.article.model.Article;
import com.tao.blog.u.article.service.IArticleService;

@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements IArticleService {

	@Autowired
	ArticleMapper articleMapper;
	
	@Override
	public List<Article> queryAll(Article t) {
		return articleMapper.queryAll(t);
	}

	@Override
	public Article queryById(String id) {
		return articleMapper.queryById(id);
	}

	@Override
	public PageInfo<Article> pageHelpers(Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 4 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return new PageInfo<Article>(articleMapper.queryAll(null));
	}

	@Override
	public boolean update(Article t) {
		return super.update(t);
	}

	@Override
	public boolean delete(String id) {
		return super.delete(id);
	}

	@Override
	public boolean save(Article t) {
		return super.save(t);
	}

}
