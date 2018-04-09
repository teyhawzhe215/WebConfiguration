package com.tutorial.security.service;

import java.util.List;

import com.tutorial.security.entities.Role;

public interface RoleService {
	List<Role> findAll();
	Role findByName (String roleName);
}
