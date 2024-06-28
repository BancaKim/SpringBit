package com.kbfg.digi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kbfg.digi.Command;
import com.kbfg.digi.login.JoinCommand;
import com.kbfg.digi.login.LoginCommand;
import com.kbfg.digi.login.MemberDeleteCommand;
import com.kbfg.digi.login.MemberListCommand;
import com.kbfg.digi.login.MemberViewCommand;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	Command command;
	@Autowired MemberListCommand memberListCommand;
	@Autowired MemberViewCommand memberViewCommand;
	@Autowired MemberDeleteCommand memberDeleteCommand;
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("home()");
		String nextPage = "home";
		return nextPage; 
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("loginForm()");
		String nextPage = "login/loginForm";
		return nextPage; 
	}
	
	@RequestMapping("/logout")
	public String loginOut(HttpSession session) {
		System.out.println("logout()");
		session.invalidate();
		return "redirect:home"; 
	}
	
	@RequestMapping(value="/loginConfirm", method = RequestMethod.POST)
	public String loginConfirm(HttpServletRequest request, Model model) {
		System.out.println("[LoginController] loginConfirm()");
		
		model.addAttribute("request", request);
		command = new LoginCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		String getMessage = (String) map.get("message");
		String nextPage = (String) map.get("nextPage");

		System.out.println("getMessage:"+getMessage);
		return nextPage;
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		String nextPage = "login/joinForm";		
		return nextPage;
	}

	@RequestMapping(value="/joinConfirm", method = RequestMethod.POST)
	public String joinConfirm(HttpServletRequest request, Model model) {
		System.out.println("[LoginController] joinConfirm()");
		
		model.addAttribute("request", request);
		command = new JoinCommand();
		command.execute(model);
		
		Map<String, Object> map = model.asMap();
		String getMessage = (String) map.get("message");
		String nextPage = (String) map.get("nextPage");

		System.out.println("getMessage:"+getMessage);
		return nextPage;
	}
	
	@RequestMapping("/memberList")
	public String memberList(HttpServletRequest request, Model model) {
		System.out.println("[LoginController] memberList()");
		
		model.addAttribute("request", request);
		memberListCommand.execute(model);
		
		Map<String, Object> map = model.asMap();
		String getMessage = (String) map.get("message");
		String nextPage = (String) map.get("nextPage");

		System.out.println("getMessage:"+getMessage);
		return nextPage;
	}

	@RequestMapping("/memberView")
	public String memberView(HttpServletRequest request, Model model) {
		System.out.println("[LoginController] memberList()");
		
		model.addAttribute("request", request);
		memberViewCommand.execute(model);
		
		Map<String, Object> map = model.asMap();
		String getMessage = (String) map.get("message");
		String nextPage = (String) map.get("nextPage");
	
		System.out.println("getMessage:"+getMessage);
		return nextPage;
	}
	
	@RequestMapping("/memberDelete")
	public String memberDelete(HttpServletRequest request, Model model) {
		System.out.println("[LoginController] memberDelete()");
		
		model.addAttribute("request", request);
		memberDeleteCommand.execute(model);
		
		Map<String, Object> map = model.asMap();
		String getMessage = (String) map.get("message");
		String nextPage = (String) map.get("nextPage");
	
		System.out.println("getMessage:"+getMessage);
		return nextPage;
	}
}
