package com.springmvc.homecontroller;





import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


import com.springmvc.classes.User;

@Controller
@RequestMapping("/")
public class HomeController {
	

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView displayHomePage() {
		ModelAndView mav = new ModelAndView("home");
		
		return mav;
	}
	
	@RequestMapping(value="/form", method= RequestMethod.GET)
	
	public ModelAndView displayForm(@ModelAttribute("user") User u){
		ModelAndView mav = new ModelAndView("form");
		
		return mav;
	}
	
	@RequestMapping(value="/process-form", method=RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("user") @Valid User u, BindingResult errors) {
		if(errors.hasErrors()) {
			for(int i = 0 ; i < errors.getAllErrors().size(); i++) {
				System.out.println(errors.getAllErrors().get(i).getDefaultMessage());
			}
			
			ModelAndView mav = new ModelAndView("form");
			return mav;
		}
		ModelAndView mav = new ModelAndView("submission-details");
				
		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		binder.setDisallowedFields(new String[] {"userName"});
	}
	
	


}
