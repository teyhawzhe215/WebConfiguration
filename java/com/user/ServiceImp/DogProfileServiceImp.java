package com.user.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.entities.DogProfile;
import com.user.dao.dogProfileDao;
import com.user.service.DogProfileService;

@Service("dogProfileService")
public class DogProfileServiceImp implements DogProfileService {

	@Autowired
	dogProfileDao dogProfileDao;
	
	@Override
	public List<DogProfile> getDogProfile() {
		// TODO Auto-generated method stub
		return dogProfileDao.getDogProfile();
	}

}
