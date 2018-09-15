package com.lqc.dao;

import java.util.List;

import com.lqc.entity.User;

public interface UserDao {

	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<User> getUsers();

	/**
	 * 根据手机号查找用户
	 * @param mobile 手机号
	 * @return
	 */
	User findByMobile(String mobile);

	/**
	 * 该手机号是否已经存在
	 * @param mobile 手机号
	 * @return
	 */
	Boolean isExistMobile(String mobile);

	/**
	 * 保存用户信息
	 * @param user 用户
	 */
	void save(User user);

}
