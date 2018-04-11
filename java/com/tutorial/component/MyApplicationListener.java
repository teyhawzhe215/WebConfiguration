package com.tutorial.component;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener{
	
	private static final Logger LOG = Logger.getLogger(MyApplicationListener.class);
	
	@EventListener // (1)
	public void handleBadCredentials(
	    AuthenticationFailureBadCredentialsEvent event) { // (2)
		LOG.debug("Bad credentials is detected. username : {}"+event.getAuthentication().getName());
	    // omitted
	}

}
