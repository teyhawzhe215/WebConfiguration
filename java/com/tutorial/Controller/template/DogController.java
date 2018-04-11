package com.tutorial.Controller.template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.user.service.DogProfileService;

@Controller
@SessionAttributes("roles")
@RequestMapping("/dog")
public class DogController {

	@Autowired
	@Qualifier("dogProfileService")
	DogProfileService dogProfileService;
	
	
	@RequestMapping(value="/DogPage")
	public String getDogPage(HttpSession session ,  Model model) {
		
		System.out.println("session " + session.getAttribute("roles"));
		
		String rootPath = System.getProperty("catalina.home");
		System.out.println("rootPath  " + rootPath);
		
		
		model.addAttribute("list", dogProfileService.getDogProfile());
		
		
		return "logout/dog";
	}
	
	
	
	
	
	
}
