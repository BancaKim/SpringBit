package com.kbfg.digi.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kbfg.digi.Command;
import com.kbfg.digi.DAO.BoardDAO;
import com.kbfg.digi.DTO.BoardBean;

@Service
public class BModifyActionCommand implements Command {
	
	@Autowired BoardDAO boarddao;
	@Autowired BoardBean boarddata;
	boolean result = false;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		
		 boolean usercheck=boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));
		 if(usercheck==false){
		   		model.addAttribute("message","비밀번호 오류");
	   			model.addAttribute("nextPage","redirect:boardDetailAction?num="+num);
		 } else {
			 try{
				 boarddata.setBOARD_NUM(num);
				 boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
				 boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
				 
				 result = boarddao.boardModify(boarddata);
				 if(result==false){
			   		System.out.println("수정실패");
		   			model.addAttribute("nextPage","redirect:boardDetailAction?num="+num);
			   	 } else {
			   	 System.out.println("수정 성공");
			   	 model.addAttribute("message","수정 성공");
			   	 model.addAttribute("nextPage","redirect:boardDetailAction?num="+num);
			   	 	}
				 }catch(Exception ex){
		   			ex.printStackTrace();	 
			 }
		 }
	}
}