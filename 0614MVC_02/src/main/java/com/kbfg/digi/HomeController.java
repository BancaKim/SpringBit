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
	
	@RequestMapping(value="/studentConfirm", method=RequestMethod.GET)
	public String studentRedirect(HttpServletRequest request) {
		String id = request.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOk";
		}
			return "redirect:studentNg";
	}

	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "student/studentOk";
	}
	@RequestMapping("/studentNg")
	public String studentNg(Model model) {
		return "student/studentNg";
	}	
	
	@RequestMapping("/studentURL1")
	public String sutdentURL1(Model model) {
		return "redirect:http://localhost:8080/digi/studentURL1.jsp";
	}
	
	@RequestMapping("/studentURL2")
	public String studentURL2(Model model) {
		return "redirect:student/studentURL2";
	}
	@RequestMapping("/student/studentURL2")
	public String studentURL22(Model model) {
		return "redirect:http://localhost:8080/digi/studentURL2.jsp";
	}
	
}
