package com.tutorial.security.dao;

import java.util.List;

import com.tutorial.security.entities.UserRole;

public interface UserRoleDao {
	
	List<UserRole> getUserRole(String email);
	
	List<UserRole> getAllRole();
	
	void save(UserRole userRole);
}
