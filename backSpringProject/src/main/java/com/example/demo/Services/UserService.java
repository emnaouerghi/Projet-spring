package com.example.demo.Services;

import java.util.List;

import com.example.demo.Models.User;

public interface UserService {
	User saveUser(User u);
	User updateUser(User u);
	void deleteUser(User u);
	void deleteUserById(Long id);
	User getUser(Long id);
	List<User> getAllUsers();
//	public User findUser(String username);
}
