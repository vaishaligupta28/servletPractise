package com.testbatis;

import java.util.List;

public interface InfoMapper {
	public void insertUser(User user);
	public User getUserById(Integer userId);
	public List<User> getAllUsers();
	public void updateUser(User user);
	public void deleteUser(Integer userId);
}
