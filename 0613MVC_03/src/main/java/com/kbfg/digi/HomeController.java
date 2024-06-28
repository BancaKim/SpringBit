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
	
//	@RequestMapping(value = "/studentView", method = RequestMethod.GET) //url 입력 http://localhost:8080/digi/studentView/studentId=10 
//	public String studentGetView(@RequestParam("studentId") String id, Model model) {
//		
//		model.addAttribute("studentId",id);
//		
//		return "student/studentView";
//	}
	
//	@RequestMapping(value = "/studentView", method = RequestMethod.POST) //url 입력 http://localhost:8080/digi/studentView/studentId=10 
//	public ModelAndView studentPostView(Member member) {
//		
//		ModelAndView mv = new ModelAndView();
//		
//		mv.addObject("member",member);
//		mv.setViewName("student/studentView");
//		
//		return mv;
//	}
	
//	@RequestMapping(value = "/studentView", method = RequestMethod.POST) //url 입력 http://localhost:8080/digi/studentView/studentId=10 
//	public String studentPostView(Member member, Model model) {
//		
//		model.addAttribute("member",member);
//		return "student/studentView";
//	}
//	
	@RequestMapping(value = "/studentView", method = RequestMethod.POST) //url 입력 http://localhost:8080/digi/studentView/studentId=10 
	public String studentPostView(@RequestParam("id") String id,
								  @RequestParam("password") String password,
								  @RequestParam("email") String email,
								  @RequestParam("userName") String userName,
								  @RequestParam("ssn") String ssn,
								  @RequestParam("birthYear") String birthYear,
								  @RequestParam("birthMonth") String birthMonth,
								  @RequestParam("birthDay") String birthDay,
								  @RequestParam("introduction") String introduction, Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("password", password);
		model.addAttribute("email", email);
		model.addAttribute("userName", userName);
		model.addAttribute("ssn", ssn);
		model.addAttribute("birthYear", birthYear);
		model.addAttribute("birthMonth", birthMonth);
		model.addAttribute("birthDay", birthDay);
		model.addAttribute("introduction", introduction);
		
		return "student/studentView2";
	}
}
