package com.tao.blog.u.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tao.blog.s.common.BaseServiceImpl;
import com.tao.blog.u.users.mapper.UsersMapper;
import com.tao.blog.u.users.model.Users;
import com.tao.blog.u.users.service.IUsersService;

/**
 * 用户管理
 * @author tao
 *
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<Users> implements IUsersService{

	@Autowired
	UsersMapper usersMapper;
	
	@Override
	public List<Users> queryAll(Users t) {
		// TODO Auto-generated method stub
		return usersMapper.queryAll(t);
	}
		
	/**
	 * 用户登录
	 * @param u
	 * @return
	 */
	public Users login(String usernm,String passwd) {
		Users u=new Users();
		u.setUserName(usernm);
		u.setPasswd(passwd);
		return usersMapper.queryObject(u);
	}
	
	
	
}
