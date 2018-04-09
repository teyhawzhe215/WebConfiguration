package com.tutorial.security.service;

import com.tutorial.security.entities.Userandpass;

public interface UserandpassService {
	Userandpass getUserandpass(String email);
	
	void save(Userandpass userandpass);
}
