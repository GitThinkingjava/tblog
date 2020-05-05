package com.tao.blog.u.users.controller;

import com.tao.blog.s.annotation.ApiIdempotent;
import com.tao.blog.s.common.BaseController;
import com.tao.blog.s.constants.Constant;
import com.tao.blog.s.rest.Resp;
import com.tao.blog.s.rest.ReturnRest;

import com.tao.blog.s.utils.RedisToken;
import com.tao.blog.u.users.UsersHelper;
import com.tao.blog.u.users.model.Users;
import com.tao.blog.u.users.service.IUsersService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(UsersHelper.PLUGIN_MAPPING)
public class UserController extends BaseController {

	@Autowired
	IUsersService usersService;


	@Autowired
	private RedisToken redisToken;

	@ResponseBody
	@ApiOperation("rest查询所有用户")
	@ApiImplicitParam(name = "User", value = "查询所有用户", required = true, dataType = "String")
	@RequestMapping("all")
	public List<Users> getAllUser() {
		return usersService.queryAll(null);
	}


	@ApiOperation("查询所用用户 ")
	@RequestMapping("list")
    public String list() {
    	this.setReqAttr("UserList", usersService.queryAll(null));
        return "list";
	}


	@ResponseBody
	@ApiOperation("rest获取token ")
	@RequestMapping("add")
	@ApiIdempotent(type = Constant.API_HEAD)
	public ReturnRest<Object> add(Users users){
			boolean flag=usersService.save(users);
			return Resp.success(flag ?"保存成功!":"保存失败");
	}


	@ResponseBody
	@ApiOperation("rest获取token ")
	@RequestMapping("getToken")
	public ReturnRest<Object> getToken(){
		String token=redisToken.setToken();
		return Resp.success(token);
	}

	@Override
	public String getModulePath() {

		return UsersHelper.PLUGIN_MAPPING;
	}

}
