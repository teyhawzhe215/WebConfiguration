package com.tutorial.security.service;

import java.util.List;

import com.tutorial.security.entities.UserRole;

public interface UserRoleService {

	List<UserRole> getUserRole(String email);
	
	List<UserRole> getAllRole();
	
	void save(UserRole userRole);
}
