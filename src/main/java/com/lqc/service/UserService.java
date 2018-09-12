package com.lqc.service;

import java.util.List;

import com.lqc.entity.User;

public interface UserService {

	List<User> getUsers();

	Boolean login(String mobile, String password);

	User findByMobileAndPassword(String mobile, String password);

	User findByMobile(String mobile);

	User getCurrent();
	
	String getCurrentId();

}
