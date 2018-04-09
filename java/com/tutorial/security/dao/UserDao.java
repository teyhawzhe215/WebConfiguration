package com.tutorial.security.dao;

import com.tutorial.security.entities.User;

public interface UserDao {
	
	User getUser(String email);
	
	void save(User user);
}
