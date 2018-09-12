package com.lqc.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lqc.entity.User;
import com.lqc.service.UserService;

@Controller
public class CommonController {
	
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		Subject currentUser = SecurityUtils.getSubject();
		return currentUser.isAuthenticated() ? "redirect:/main" : "/common/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password) {
		Subject currentUser = SecurityUtils.getSubject();
		//测试当前用户是否已经被认证，即是否登录
        if (!currentUser.isAuthenticated()) {
        	//把用户名和密码封装为UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
            	//执行登录
                currentUser.login(token);
            }
            //所有认证时异常的父类
            catch (AuthenticationException ae) {
                System.out.println("登录失败："+ ae.getMessage());
            }
        }
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(ModelMap modelMap) {
		User user = userService.getCurrent();
		modelMap.put("userName", user.getName());
		return "/common/main";
	}
	
	@RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
	public String unauthorized(ModelMap model) {
		return "/common/unauthorized";
	}

}
