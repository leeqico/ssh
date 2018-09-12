package com.lqc.dao;

import java.util.List;

import com.lqc.entity.User;

public interface UserDao {

	List<User> getUsers();

	Boolean login(String mobile, String password);

	User findByMobileAndPassword(String mobile, String password);

	User findByMobile(String mobile);

}
