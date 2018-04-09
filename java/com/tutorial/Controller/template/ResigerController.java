package com.tutorial.Controller.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutorial.security.entities.User;
import com.tutorial.security.entities.UserRole;
import com.tutorial.security.entities.Userandpass;
import com.tutorial.security.service.UserRoleService;
import com.tutorial.security.service.UserService;
import com.tutorial.security.service.UserandpassService;

@Controller
public class ResigerController {

	@Autowired
	@Qualifier("SecurityUserService")
	UserService userService;
	
	@Autowired
	UserandpassService userandpassService;
	
	@Autowired
	UserRoleService userRoleService;
	
	@RequestMapping(value="/registerAction" , method = RequestMethod.GET)
	public String registerAction(@ModelAttribute User user , Model model) {
	
		System.out.println("user =" + user.toString());
		
		userService.save(user);
		
		Userandpass u =new Userandpass();
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		
		userandpassService.save(u);
		
		UserRole roleU = new UserRole();
		roleU.setEmail(user.getEmail());
		roleU.setRoleName("USER");
		
		userRoleService.save(roleU);
		
		model.addAttribute("user", user);
		
		return "views/register";
		
		 
	}
	
	
	
	
}
