package com.lqc.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
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
	@Transactional(readOnly = true)
	public User findByMobile(String mobile) {
		User user = userDao.findByMobile(mobile);
		return user;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Boolean isExistMobile(String mobile) {
		Boolean isExist = userDao.isExistMobile(mobile);
		return isExist;
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

	@Override
	@Transactional
	public void register(String name, String mobile, String password) {
		String algorithmName = "MD5";
		Object salt = ByteSource.Util.bytes(mobile);
		int hashIterations = 1024;
		Object source = new SimpleHash(algorithmName, password, salt, hashIterations);
		User user = new User();
		String id = UUID.randomUUID().toString().replace("-", "");
		user.setId(id);
		user.setName(name);
		user.setMobile(mobile);
		user.setPassword(String.valueOf(source));
		user.setSalt(String.valueOf(salt));
		userDao.save(user);
	}

}
