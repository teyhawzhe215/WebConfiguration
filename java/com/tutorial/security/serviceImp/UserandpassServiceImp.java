package com.tutorial.security.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.security.dao.UserandpassDao;
import com.tutorial.security.entities.Userandpass;
import com.tutorial.security.service.UserandpassService;

@Service
public class UserandpassServiceImp implements UserandpassService {

	@Autowired
	UserandpassDao userandpassDao;
	
	@Override
	public Userandpass getUserandpass(String email) {
		// TODO Auto-generated method stub
		return userandpassDao.getUserandpass(email);
	}

	@Override
	public void save(Userandpass userandpass) {
		// TODO Auto-generated method stub
		userandpassDao.save(userandpass);
	}

}
