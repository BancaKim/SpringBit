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
public class MemberController {
	
	@RequestMapping("joinPage")
	public String joinPage() {
		return "joinPage";
	}
	
	@RequestMapping(value="/studentView", method=RequestMethod.POST)
	public String studentCreate(@ModelAttribute("member")@Valid Member member, BindingResult result) {
		
		String page = "/student/studentView";
		
		if(result.hasErrors()) {
			page= "joinPage";
		}
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
}
