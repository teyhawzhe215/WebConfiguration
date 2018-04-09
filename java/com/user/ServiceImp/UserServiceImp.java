package com.user.ServiceImp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tutorial.entities.User;
import com.user.dao.UserDao;
import com.user.service.UserService;

@Service("UserService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

}
