package com.tutorial.Controller.template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="failloginPage" , method = RequestMethod.POST )
	public String fail(@RequestParam String email , @RequestParam String user) {
		
		
		
		return "";
		
	}
	
	/*@RequestMapping(value="/logoutAction")
	public String logout(HttpServletRequest request , HttpServletResponse response ) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("auth  "+auth);
		if(auth!=null) {
			System.out.println("come here");
			new SecurityContextLogoutHandler().logout(request, response, auth);
			
			HttpSession session= request.getSession(false);
	        SecurityContextHolder.clearContext();
	        if(session != null) {
	            session.invalidate();
	        }
			
		}
		return "redirect:/homePage";
	}*/
	
	
}
