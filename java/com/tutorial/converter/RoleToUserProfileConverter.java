package com.tutorial.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.tutorial.security.entities.Role;
import com.tutorial.security.service.RoleService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {

	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
	@Autowired
	RoleService roleService;
	
	@Override
	public Role convert(Object element) {
		// TODO Auto-generated method stub
		logger.info("go to role convert");
		logger.info(String.valueOf(element));
		String roleName = String.valueOf(element);
		
		Role role= roleService.findByName( roleName );
		
		logger.info("role : {}",role);
		
		return role;
	}

}
