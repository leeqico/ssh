package com.lqc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lqc.entity.User;
import com.lqc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@RequestMapping(value = "/list")
	private String list(ModelMap modelMap) {
		return "/user/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/load")
	private List<User> load(ModelMap modelMap) {
		List<User> users = userService.getUsers();
		return users;
	}
	
}
