package com.kbfg.digi;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	
	
//	@RequestMapping(value="/createDonePage", method=RequestMethod.POST)
//	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {
//		
//		String page = "createDonePage";
//		
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
//		if(result.hasErrors()) {
//			page= "createPage";
//		}
//		return page;
//	}
	
	@RequestMapping(value="/createDonePage", method=RequestMethod.POST)
	public String studentCreate(@ModelAttribute("student")@Valid Student student, BindingResult result) {
		
		String page = "createDonePage";
		
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
		
		if(result.hasErrors()) {
			page= "createPage";
		}
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
}
