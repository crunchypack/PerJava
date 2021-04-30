package springwork.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springwork.entities.User;
import springwork.services.UserServices;

@Controller
public class UserController {
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login_form");
		return mav;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginTry(HttpServletRequest request) {
		UserServices us = new UserServices();
		
		User u = us.getByEmail(request.getParameter("email"));
		if(u != null) {
			if(u.getPassword().equals(request.getParameter("password"))) {
				ModelAndView mav = new ModelAndView("login_success");
				mav.addObject("name", u.getFirstName());
				return mav;
			}
			else {
				ModelAndView mav = new ModelAndView("login_form");
				mav.addObject("error", "Wrong password");
				
				return mav;
			}
		}
		ModelAndView mav = new ModelAndView("login_form");
		mav.addObject("error", "Email doesn't exist");
		
		return mav;
		
		
		
		
		
	}

}
