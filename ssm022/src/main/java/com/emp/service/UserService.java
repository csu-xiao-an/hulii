package com.emp.service;

import java.util.Set;

import com.emp.entity.User;

public interface UserService {
	/** 通过用户名查找用户 */
	public User queryByUserName(String username);

	/** 通过用户名查找该用户所有的角色并保存在Set集合中 */
	public Set<String> queryRoles(String username);

	/** 通过用户名查找该用户所有的权限并保存在Set集合中 */
	public Set<String> queryPermissions(String username);

	/* 注册添加用户 */
	public void addUser(User user);
}
