package com.tutorial.security.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tutorial.security.dao.UserDao;
import com.tutorial.security.entities.User;
import com.tutorial.security.service.UserService;

@Service("SecurityUserService")
public class UserServiceImp implements UserService {

	@Autowired
	@Qualifier("SUser")
	UserDao userDao;
	

	
	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return userDao.getUser(email);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

}
