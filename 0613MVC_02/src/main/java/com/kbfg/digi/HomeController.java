package com.kbfg.digi;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/studentView", method = RequestMethod.GET) //url �Է� http://localhost:8080/digi/studentView/studentId=10 
	public String studentGetView(@RequestParam("studentId") String id, Model model) {
		
		model.addAttribute("studentId",id);
		
		return "student/studentView";
	}
	
	@RequestMapping(value = "/studentView", method = RequestMethod.POST) //url �Է� http://localhost:8080/digi/studentView/studentId=10 
	public ModelAndView studentPostView(HttpServletRequest httpServletRequest) {
		String id = httpServletRequest.getParameter("studentId");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("studentId",id);
		mv.setViewName("student/studentView");
		
		return mv;
	}
	
}
