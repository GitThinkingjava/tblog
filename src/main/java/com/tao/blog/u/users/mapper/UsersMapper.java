package com.tao.blog.u.users.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tao.blog.s.common.BaseDao;
import com.tao.blog.u.users.model.Users;

/**
 * UsersDAO继承基类
 */
@Mapper
public interface UsersMapper extends BaseDao<Users> {

}