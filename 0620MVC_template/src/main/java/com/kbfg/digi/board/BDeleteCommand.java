package com.kbfg.digi.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kbfg.digi.Command;
import com.kbfg.digi.DAO.BoardDAO;

@Service
public class BDeleteCommand implements Command {
	
	@Autowired BoardDAO boarddao;
   	boolean usercheck=false;
	boolean result=false;

	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
	   	int num=Integer.parseInt(request.getParameter("num"));
	   	
	   	usercheck=boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));
	   	
	  	if(usercheck==false){
	   		System.out.println("아이디가 일치하지 않습니다");
	   		model.addAttribute("nextPage","redirect:list");
	   	} else {
	   	System.out.println("아이디가 일치합니다");
	   	result=boarddao.boardDelete(num);
	   	if(result==false) {
		   	System.out.println("에러 발생");
	   		model.addAttribute("nextPage","redirect:list");
	   		} else {
		   	System.out.println("삭제 성공");
	   		model.addAttribute("nextPage","redirect:list");
	   		}
	   	}
	   
	 }
}