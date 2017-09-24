package com.microservice.user.dao;

import java.util.List;

import com.microservice.user.model.User;

public interface UserDao {
	
	int insert(User user);

	User findById(int id);
	
	List<User> findAll();
	
	int update(User user);
	
	boolean isUser(int id);

}
