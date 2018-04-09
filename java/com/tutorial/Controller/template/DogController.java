package com.tutorial.Controller.template;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("roles")
@RequestMapping("/dog")
public class DogController {

	
	
	@RequestMapping(value="/DogPage")
	public String getDogPage(HttpSession session) {
		
		System.out.println("session " + session.getAttribute("roles"));
		
		
		return "logout/dog";
	}
	
	
	@RequestMapping(value="/logoutAction")
	public String logout(HttpSession session) {
		
		System.out.println("session " + session.getAttribute("roles"));
		return "/";
	}
	
	
}
