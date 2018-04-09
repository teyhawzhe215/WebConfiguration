package com.tutorial.security.dao;

import com.tutorial.security.entities.Userandpass;

public interface UserandpassDao {
	Userandpass getUserandpass(String email);
	
	void save(Userandpass userandpass);
}
