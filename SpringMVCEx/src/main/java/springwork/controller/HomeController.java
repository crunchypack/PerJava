package springwork.controller;


import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.classes.User;

@Controller
public class HomeController {
	

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView("welcome");
		
		mav.addObject("message","Welcome");
		return mav;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		
		return mav;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register(@ModelAttribute("user") User u) {
		ModelAndView mav = new ModelAndView("register");
		
		return mav;
	}
	@RequestMapping("/process-login")
	public ModelAndView userPage(HttpServletRequest request) {
		 System.out.println(request.getParameter("userName"));
		 System.out.println(request.getParameter("password"));
		 
		 return new ModelAndView("login");
		
			
	}
	@RequestMapping(value="/process-registration", method=RequestMethod.POST)
	public ModelAndView userInfo(@ModelAttribute("user") User u) {
		ModelAndView mav = new ModelAndView("register");
		System.out.println(u.getFirstName());
		System.out.println(u.getLastName());
		System.out.println(u.getUserName());
		System.out.println(u.getGender());
		System.out.println(u.getContactInfo().getPhoneNumber());
		System.out.println(u.getContactInfo().getEmail());
		System.out.println(u.getPrivateInfo().getDob());
		
		return mav;
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public ModelAndView contactForm() {
		ModelAndView mav = new ModelAndView("contact");
		
		return mav;
	}
	@RequestMapping("/confirm")
	public ModelAndView userMessage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("sent");
		
		mav.addObject("name", request.getParameter("name"));
		
		return mav;		
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public ModelAndView aboutMe() {
		return new ModelAndView("about");
	}

}
