package com.tutorial.Controller.template;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tutorial.security.entities.UserRole;
import com.tutorial.security.service.UserRoleService;
import com.user.service.UserService;

@Controller
@SessionAttributes("roles")
public class TemplateController {

	@Autowired
	@Qualifier("UserService")
	public UserService userService;
	
	@Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	@Qualifier("AnimalService")
	public com.tutorial.animalgroup.service.UserService service;
	
	@Autowired
	public UserRoleService userRoleService;
	
	@RequestMapping(value= {"/","/homePage"} , method = {RequestMethod.GET ,  RequestMethod.POST})
	public String getTemplate() {
		
		if(isCurrentAuthenticationAnonymous()) {
			System.out.println("template");
			return "template";
		}else {
			System.out.println("redirect:/dog/DogPage");
			return "redirect:/dog/DogPage";
		}
		
	}
	
	@RequestMapping(value="/registerPage" , method = RequestMethod.GET)
	public String getRegister(Model model) {
		System.out.println("register");
		model.addAttribute("user",new com.tutorial.entities.User());
		return "login/register";
	}
	
	@RequestMapping(value="/contactPage", method = RequestMethod.GET)
	public String getContact() {
		System.out.println("contact");

		if(isCurrentAuthenticationAnonymous()) {
			return "login/contact";
		}
		
		return "logout/contact";
	}
	
	@RequestMapping(value= "/loginPage" , method = RequestMethod.GET)
	public String getLogin(@RequestParam(required = false) String error,@RequestParam(required = false) String email) {
		return "login/login";
	}
	
	
	@ModelAttribute("roles")
	 public List<UserRole> initializeProfiles() {
		
		 System.out.println("in roles");
		 System.out.println(userRoleService.getAllRole());
	     return userRoleService.getAllRole();
	}
	
	@RequestMapping(value= "/loginAction" , method = RequestMethod.POST)
	public String getLoginAction() {
		System.out.println("login!!!");
		System.out.println("trueOrfalse:"+isCurrentAuthenticationAnonymous());
		
		return "login/login";
	}
	
	private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("isCurrentAuthenticationAnonymous()"+authentication);
        return authenticationTrustResolver.isAnonymous(authentication);
    }
	
	@RequestMapping(value= "/Access_Denied" , method = {RequestMethod.GET , RequestMethod.POST })
	public String getAccessDenied() {
		System.out.println("Access_Denied!!!");
		return "login/accessDenied";
	}
	
	
}
