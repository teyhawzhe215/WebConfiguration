package com.tutorial.security.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tutorial.security.dao.UserDao;
import com.tutorial.security.entities.User;
import com.tutorial.security.entities.UserRole;
import com.tutorial.security.entities.Userandpass;
import com.tutorial.security.service.UserRoleService;
import com.tutorial.security.service.UserandpassService;

@Service
public class userDetailsService implements UserDetailsService {

	@Autowired
	@Qualifier("SUser")
	UserDao userDao;
	
	@Autowired
	UserRoleService userRoleService;
	
	@Autowired
	UserandpassService userandpassService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("loadUserByUsername "+username);
		
		User user = userDao.getUser(username);

		 if(user==null){
	         throw new UsernameNotFoundException("Username not found");
	     }
		
		 
		Userandpass  up = userandpassService.getUserandpass(user.getEmail());
		 
		System.out.println("user "+user);
		System.out.println("Userandpass "+up);
	 
		return  new org.springframework.security.core.userdetails.User(user.getEmail(), up.getPassword(), 
                true, true, true, true, getGrantedAuthorities(user));
	}
	
	  private List<GrantedAuthority> getGrantedAuthorities(User user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        
	        System.out.println("getGrantedAuthorities");
	        
	        List<UserRole> list =  userRoleService.getUserRole(user.getEmail());
	        
	        for(UserRole userRole : list){
	            authorities.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRoleName()));
	            System.out.println("role list = " + userRole.getRoleName());
	        }

	        return authorities;
	    }

}
