package com.tutorial.security.dao;

import com.tutorial.security.entities.Login;

public interface LoginDao {
	
	void save(Login login);
	
	Login getByKey(String key);
	
	void update(Login login);
	
	void delete(String login);
}
