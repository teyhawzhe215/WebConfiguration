package com.tutorial.animalgroup.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.animalgroup.dao.UserDao;
import com.tutorial.animalgroup.entities.User;
import com.tutorial.animalgroup.service.UserService;

@Service("AnimalService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}

}
