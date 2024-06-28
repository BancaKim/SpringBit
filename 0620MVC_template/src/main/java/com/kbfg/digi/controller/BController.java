package com.kbfg.digi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kbfg.digi.Command;
import com.kbfg.digi.board.BContentCommand;
import com.kbfg.digi.board.BDeleteCommand;
import com.kbfg.digi.board.BListCommand;
import com.kbfg.digi.board.BModifyActionCommand;
import com.kbfg.digi.board.BModifyCommand;
import com.kbfg.digi.board.BReplyActionCommand;
import com.kbfg.digi.board.BReplyCommand;
import com.kbfg.digi.board.BWriteCommand;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
@RequestMapping("/board")
public class BController {

	Command command = null;
	@Autowired BListCommand bListCommand;
	@Autowired BContentCommand bContentCommand;
	@Autowired BDeleteCommand bDeleteCommand;
	@Autowired BReplyCommand bReplyCommand;
	@Autowired BReplyActionCommand bReplyActionCommand;
	@Autowired BModifyCommand bModifyCommand;
	@Autowired BModifyActionCommand bModifyActionCommand;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("list()");
		model.addAttribute("request", request);

//		command = new BListCommand();
		bListCommand.execute(model);

		String nextPage = "board/boardList";
		return nextPage;
	}
	
	@RequestMapping("/boardwrite")
	public String write_view(Model model) {
		System.out.println("write_view()");
		String nextPage = "board/boardWrite";
		return nextPage;
	}
	
	@RequestMapping("/boardAddAction")
	public String boardAddAction(HttpServletRequest request, Model model) {
		System.out.println("boardAddAction()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		String nextPage = "redirect:list";
		return nextPage;
	}
	
	@RequestMapping("/boardDetailAction")
	public String boardDetailAction(HttpServletRequest request, Model model) {
		System.out.println("boardAddAction()");
		
		model.addAttribute("request", request);
		bContentCommand.execute(model);
		
		Map<String, Object> map = model.asMap();
		String nextPage = (String) map.get("nextPage");
		return nextPage;
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(HttpServletRequest request, Model model) {
		System.out.println("boardDelete()");
		String num = request.getParameter("num");
		String nextPage = "board/boardDelete";
		model.addAttribute("num",num);
		return nextPage;
	}
	
	@RequestMapping("/boardDeleteAction")
	public String boardDeleteAction(HttpServletRequest request, Model model) {
		System.out.println("boardDelete()");
		
		model.addAttribute("request", request);
		bDeleteCommand.execute(model);
		
		Map<String, Object> map = model.asMap();
		String nextPage = (String) map.get("nextPage");
		return nextPage;
	}
	
	@RequestMapping("/boardReply")
	public String boardReply(HttpServletRequest request, Model model) {
		System.out.println("boardReply()");
		
		model.addAttribute("request", request);
		bReplyCommand.execute(model);

		Map<String, Object> map = model.asMap();
		String nextPage = (String) map.get("nextPage");
		return nextPage;
	}
	
	@RequestMapping("/boardReplyAction")
	public String boardReplyAction(HttpServletRequest request, Model model) {
		System.out.println("boardReplyAction()");
		
		model.addAttribute("request", request);
		bReplyActionCommand.execute(model);
		
		Map<String, Object> map = model.asMap();
		String nextPage = (String) map.get("nextPage");
		return nextPage;
	}
	
	@RequestMapping("/boardModify")
	public String boardModify(HttpServletRequest request, Model model) {
		System.out.println("boardModify()");
		
		model.addAttribute("request", request);
		bModifyCommand.execute(model);

		Map<String, Object> map = model.asMap();
		String nextPage = (String) map.get("nextPage");
		return nextPage;
	}
	
	@RequestMapping("/boardModifyAction")
	public String boardModifyAction(HttpServletRequest request, Model model) {
		System.out.println("boardModifyAction()");
		
		model.addAttribute("request", request);
		bModifyActionCommand.execute(model);
		
		Map<String, Object> map = model.asMap();
		String nextPage = (String) map.get("nextPage");
		return nextPage;
	}
}
