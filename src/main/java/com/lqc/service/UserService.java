package com.lqc.service;

import java.util.List;

import com.lqc.entity.User;

public interface UserService {

	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> getUsers();

	/**
	 * 根据手机号查找用户
	 * @param mobile
	 * @return
	 */
	User findByMobile(String mobile);
	
	/**
	 * 该手机号是否已经存在
	 * @param mobile
	 * @return
	 */
	Boolean isExistMobile(String mobile);

	/**
	 * 获取当前登录的用户
	 * @return
	 */
	User getCurrent();
	
	/**
	 * 获取当前登录用户的id
	 * @return
	 */
	String getCurrentId();

	/**
	 * 用户注册
	 * @param mobile
	 * @param password
	 */
	void register(String name, String mobile, String password);

}
