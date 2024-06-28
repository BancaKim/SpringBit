package com.javalec.springMVCBoard.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.springMVCBoard.command.BCommand;
import com.javalec.springMVCBoard.command.BContentCommand;
import com.javalec.springMVCBoard.command.BDeleteCommand;
import com.javalec.springMVCBoard.command.BListCommand;
import com.javalec.springMVCBoard.command.BModifyCommand;
import com.javalec.springMVCBoard.command.BReplyCommand;
import com.javalec.springMVCBoard.command.BReplyViewCommand;
import com.javalec.springMVCBoard.command.BWriteCommand;
import com.javalec.springMVCBoard.util.Constant;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class BController {

	BCommand command = null;
	@Autowired BListCommand bListCommand;
	@Autowired BWriteCommand bWriteCommand;
	@Autowired BContentCommand bContentCommand;
	@Autowired BModifyCommand bModifyCommand;
	@Autowired BReplyViewCommand bReplyViewCommand;
	@Autowired BReplyCommand bReplyCommand;
	@Autowired BDeleteCommand bDeleteCommand;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		System.out.println("list()");
		bListCommand.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		model.addAttribute("request", request);
		bWriteCommand.execute(model);

		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("content_view()");
		model.addAttribute("request", request);
		bContentCommand.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST )
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		model.addAttribute("request", request);
		bModifyCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model){
		System.out.println("reply_view()");
		model.addAttribute("request", request);
		bReplyViewCommand.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request", request);		
		bReplyCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		bDeleteCommand.execute(model);
		
		return "redirect:list";
	}
	
}