package com.emp.service.impl;

import java.util.Set;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.UserDao;
import com.emp.entity.User;
import com.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public User queryByUserName(String username) {
		return userDao.queryByUserName(username);
	}

	public Set<String> queryRoles(String username) {
		return userDao.queryRoles(username);
	}

	public Set<String> queryPermissions(String username) {
		return userDao.queryPermissions(username);
	}

	public void addUser(User user) {
		//加盐，加密的效果
		//(算法 需要加密的密码  盐  加密的次数)
		String password = new SimpleHash("MD5", user.getPassword(), user.getUsername(), 1024).toString();
		user.setPassword(password);
		userDao.save(user);
	}

}
