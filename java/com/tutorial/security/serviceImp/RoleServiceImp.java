package com.tutorial.security.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.security.dao.RoleDao;
import com.tutorial.security.entities.Role;
import com.tutorial.security.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public Role findByName(String roleName) {
		// TODO Auto-generated method stub
		return roleDao.findByName(roleName);
	}

}
