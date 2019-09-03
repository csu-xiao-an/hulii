package com.emp.service;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class UserServiceTest {
	@Autowired
	private UserService userServce;

	@Test
	public void testQueryByUserName() {
		User user = userServce.queryByUserName("ls");
		System.out.println(user);
	}

	@Test
	public void testQueryRoles() {
		Set<String> queryRoles = userServce.queryRoles("ls");
		System.out.println(queryRoles);
	}

	@Test
	public void testQueryPermissions() {
		Set<String> queryPermissions = userServce.queryPermissions("ls");
		System.out.println(queryPermissions);
	}
	
	@Test
	public void testAdd(){
		User user=new User();
		user.setUsername("hzy");
		user.setPassword("123");
		userServce.addUser(user);
		System.out.println("OK");
	}
}
