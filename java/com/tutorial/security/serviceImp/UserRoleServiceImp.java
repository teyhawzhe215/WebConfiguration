package com.tutorial.security.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.security.dao.UserRoleDao;
import com.tutorial.security.entities.UserRole;
import com.tutorial.security.service.UserRoleService;

@Service
public class UserRoleServiceImp implements UserRoleService {

	@Autowired
	UserRoleDao userRoleDao;
	
	@Override
	public List<UserRole> getUserRole(String email) {
		// TODO Auto-generated method stub
		return userRoleDao.getUserRole(email);
	}

	@Override
	public void save(UserRole userRole) {
		// TODO Auto-generated method stub
		userRoleDao.save(userRole);
	}

	@Override
	public List<UserRole> getAllRole() {
		// TODO Auto-generated method stub
		return userRoleDao.getAllRole();
	}

}
