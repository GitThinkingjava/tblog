package com.tao.blog.u.users.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.blog.s.common.BaseController;
import com.tao.blog.u.users.UsersHelper;
import com.tao.blog.u.users.model.Users;
import com.tao.blog.u.users.service.IUsersService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@Controller
@RequestMapping(UsersHelper.PLUGIN_MAPPING)
public class UserController extends BaseController {

	@Autowired
	IUsersService usersService;

	@ApiOperation("查询所有用户")
	@ApiImplicitParam(name = "User", value = "查询所有用户", required = true, dataType = "String")
	@ResponseBody
	@RequestMapping("all")
	public List<Users> getAllUser() {
		return usersService.queryAll(null);
	}
	/**
     * 查询所用用户
     * @return
     */
    @RequestMapping("list")
    public String list() {
    	this.setReqAttr("UserList", usersService.queryAll(null));
        return "list";
	}
    

	@Override
	public String getModulePath() {

		return UsersHelper.PLUGIN_MAPPING;
	}

}
