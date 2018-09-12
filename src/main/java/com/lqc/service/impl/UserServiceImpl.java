package com.lqc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lqc.dao.UserDao;
import com.lqc.entity.User;
import com.lqc.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Resource(name = "userDaoImpl")
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public Boolean login(String mobile, String password) {
		if (mobile == null || mobile.trim() == "" || password == null || password.trim() == "") {
			return false;
		}
		Boolean isExistUser = userDao.login(mobile, password);
		return isExistUser;
	}

	@Override
	@Transactional(readOnly = true)
	public User findByMobileAndPassword(String mobile, String password) {
		User user = userDao.findByMobileAndPassword(mobile,password);
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public User findByMobile(String mobile) {
		User user = userDao.findByMobile(mobile);
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public User getCurrent() {
		String currentId = getCurrentId();
		if (currentId != null) {
			return userDao.findByMobile(currentId);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public String getCurrentId() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			PrincipalCollection principalCollection = subject.getPrincipals();
			if(principalCollection != null) {
				Object primaryPrincipal =  principalCollection.getPrimaryPrincipal();
				if(primaryPrincipal != null) {
					return String.valueOf(primaryPrincipal);
				}
			}
		}
		return null;
	}

}
