package com.tao.blog.u.mgr.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tao.blog.s.common.BaseController;
import com.tao.blog.u.mgr.MgrHelper;
import com.tao.blog.u.users.model.Users;
import com.tao.blog.u.users.service.IUsersService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(MgrHelper.PLUGIN_MAPPING)
public class MgrController extends BaseController {

	@Autowired
	IUsersService usersService;

	@ApiOperation("登录管理页面")
	@RequestMapping("login")
	public String login(String usernm, String passwd) {
		// 不为空进行登录验证
		if (StringUtils.isNotBlank(usernm) && StringUtils.isNotBlank(passwd)) {
			Users users = usersService.login(usernm, passwd);
			if (null != users) {
				this.getSession().setAttribute(SESSION_USER, users);
				return "redirect:/article/mgr/index";
			}
			this.setReqAttr("msg", "用户名或密码错误！");
		}
		// 如果参数为空，跳转到 login 页面，
		return "login";
	}

	@Override
	public String getModulePath() {
		return MgrHelper.PLUGIN_MAPPING;
	}

}
