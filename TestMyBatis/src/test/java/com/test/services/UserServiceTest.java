package com.test.services;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.testbatis.User;
import com.testbatis.UserService;

public class UserServiceTest {
	private static UserService userService;

	@BeforeClass
	public static void setup() {
		System.out.println("SET UP------\n");
		userService = new UserService();
	}

	@AfterClass
	public static void teardown() {
		System.out.println("Tear down------\n");
		userService = null;
	}

	@Test
	public void testGetUserById() {
		System.out.println("testGetUserById()-----");
		User user = userService.getUserById(8);
		Assert.assertNotNull(user);
		System.out.println(user);
	}

	@Test
	public void testGetAllUsers() {
		System.out.println("testgetAllUsers()-----");
		List<User> users = userService.getAllUsers();
		Assert.assertNotNull(users);
		for (User user : users) {
			System.out.println(user);
		}

	}
 
	@Test
	public void testInsertUser() {
		System.out.println("testInsertUser()-----");
		User user = new User();
		user.setEmailId("rashmi@gmail.com");
		user.setPassword("rashmipwd");
		user.setFirstName("Rashmi");
		user.setLastName("tiwari");

		userService.insertUser(user);
		Assert.assertTrue(user.getUserId() != 0);
		User createdUser = userService.getUserById(user.getUserId());
		Assert.assertNotNull(createdUser);
		Assert.assertEquals(user.getEmailId(), createdUser.getEmailId());
		Assert.assertEquals(user.getPassword(), createdUser.getPassword());
		Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertEquals(user.getLastName(), createdUser.getLastName());
	}

	@Test
	public void testUpdateUser() {
		System.out.println("testUpdateUser()-----");
		User user = userService.getUserById(2);
		user.setFirstName("Shriya");
		user.setLastName("Kesharwani");
		userService.updateUser(user);
		User updatedUser = userService.getUserById(2);
		Assert.assertEquals(user.getFirstName(), updatedUser.getFirstName());
		Assert.assertEquals(user.getLastName(), updatedUser.getLastName());
	}

	@Test
	public void testDeleteUser() {
		System.out.println("testDeleteUser()-----");
		User user = userService.getUserById(4);
		userService.deleteUser(user.getUserId());
		User deletedUser = userService.getUserById(4);
		Assert.assertNull(deletedUser);
	}
}
