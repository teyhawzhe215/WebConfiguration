package com.tutorial.security.service;

import com.tutorial.security.entities.User;

public interface UserService {
	User getUser(String email);
	void save(User user);
}
