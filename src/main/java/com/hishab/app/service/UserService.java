package com.hishab.app.service;

import java.util.List;

import com.hishab.app.model.User;

public interface UserService {
	User createUser(User user);
	User findUserById(Long userId);
	List<User> getAllUsers();
	User updateUser(User user);
	void deleteUser(Long userId);
}
