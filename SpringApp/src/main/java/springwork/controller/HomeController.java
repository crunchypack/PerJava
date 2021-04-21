package springwork.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jpa.entitymodels.Course;
import jpa.service.CourseService;

@Controller
public class HomeController {
	
	@Autowired
	private CourseService cs;
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView("welcome");
		
		List<Course> courses = cs.getAllCourses();
		mav.addObject("courses",courses);
		return mav;
	}
	
	@RequestMapping("/displayroute")
	public ModelAndView userPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("UserPage");
		HttpSession se = request.getSession();
		
		se.setAttribute("u", request.getParameter("name") );
		
		mav.addObject("user_name", request.getParameter("name"));
		
		return mav;
	}

}
