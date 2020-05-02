package com.tao.blog.u.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tao.blog.s.common.BaseServiceImpl;
import com.tao.blog.u.article.mapper.CommentsMapper;
import com.tao.blog.u.article.model.Comments;
import com.tao.blog.u.article.service.ICommentsService;

@Service
@Transactional
public class CommentsServiceImpl extends BaseServiceImpl<Comments> implements ICommentsService {

	@Autowired
	CommentsMapper commentsMapper;

	@Override
	public List<Comments> queryAll(Comments t) {
		return commentsMapper.queryAll(t);
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public Comments queryById(String id) {
		// TODO Auto-generated method stub
		return super.queryById(id);
	}
}
