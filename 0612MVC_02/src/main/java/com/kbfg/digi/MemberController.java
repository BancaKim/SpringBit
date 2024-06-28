package com.kbfg.digi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kbfg.digi.member.Member;

@Controller
@RequestMapping("/member")
public class MemberController {

//	@RequestMapping("/join")
//	public String join(HttpServletRequest httpServletRequest, Model model) {
//		String name = httpServletRequest.getParameter("name");
//		String id = httpServletRequest.getParameter("id");		
//		String pw = httpServletRequest.getParameter("pw");		
//		String email = httpServletRequest.getParameter("email");		
//		
//		model.addAttribute("name", name);
//		model.addAttribute("id",id);
//		model.addAttribute("pw", pw);
//		model.addAttribute("email",email);		
//		
//		return "/member/join";
//	}
	
//	@RequestMapping("/join")
//	public String checkId(@RequestParam("name") String name,
//						  @RequestParam("id") String id,
//						  @RequestParam("pw") String pw,
//						  @RequestParam("email") String email, Model model) {		
//		model.addAttribute("name", name);
//		model.addAttribute("id",id);
//		model.addAttribute("pw", pw);
//		model.addAttribute("email",email);		
//		return "/member/join";
//	}	
	
	@RequestMapping("/join")
	public String checkId(@RequestParam("name") String name,
						  @RequestParam("id") String id,
						  @RequestParam("pw") String pw,
						  @RequestParam("email") String email, Model model) {	
		
		Member member= new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("memberInfo", member);
		return "/member/join";
	}	
	
	@RequestMapping("/join")
	public String checkId(Member member) {	
		return "/member/join";
	}	
}
