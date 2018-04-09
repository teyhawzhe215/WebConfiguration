package com.tuturial.setting;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class QuickPasswordEncodingGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      String password = "123123";
          BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
          System.out.println(passwordEncoder.encode(password));
          
          UsernamePasswordAuthenticationFilter asl;
	}

}
