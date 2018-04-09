package com.tutorial.security.dao;

import java.util.List;

import com.tutorial.security.entities.Role;

public interface RoleDao {
	
	List<Role> findAll();
	Role findByName (String roleName);
	
}
