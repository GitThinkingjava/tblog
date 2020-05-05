package com.tao.blog.u.users.mapper;

import com.tao.blog.s.common.BaseDao;
import com.tao.blog.u.users.model.Users;
import org.apache.ibatis.annotations.Mapper;


/**
 * UsersDAO继承基类
 */
@Mapper
public interface UsersMapper extends BaseDao<Users> {

}