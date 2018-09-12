package com.lqc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/getUsers")
	public String getUsers(ModelMap modelMap) {
		List<User> users = userService.getUsers();
		System.out.println(users.toString());
		if (users.size() != 0) {
			modelMap.put("users", users.toString());
		}
		return "users";
	}
	
}
