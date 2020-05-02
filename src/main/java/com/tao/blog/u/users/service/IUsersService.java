package com.tao.blog.u.users.service;

import com.tao.blog.s.common.BaseService;
import com.tao.blog.u.users.model.Users;

public interface IUsersService  extends BaseService<Users>{

	/**
	 *  用户登录
	 * @param u Users
	 * @return
	 */
    Users login(String usernm, String passwd);
}
