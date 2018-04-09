package com.tutorial.Controller.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/forget")
@SessionAttributes("roles")
public class ForgetAccController {

	
	@RequestMapping(value= "/forgetAccPage" , method = RequestMethod.GET)
	public String getForgetAccPage() {
		System.out.println("forgetAcc");
		return "logout/forgetAcc";
	}
	
	
}
