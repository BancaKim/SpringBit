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
public class BContentCommand implements Command {
	@Autowired
	BoardDAO boarddao;
	@Autowired
   	BoardBean boarddata;
	
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		BoardDAO boarddao=new BoardDAO();
//	   	BoardBean boarddata=new BoardBean();
	   	
		int num=Integer.parseInt(request.getParameter("num"));
		try {
			boarddao.setReadCountUpdate(num);
			boarddata=boarddao.getDetail(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	  	if(boarddata==null){
	   		System.out.println("게시글이 없습니다");
	   		model.addAttribute("nextPage","redirect:list");
	   	} else {
	   	System.out.println("조회완료");
	   	model.addAttribute("boarddata", boarddata);
   		model.addAttribute("nextPage","/board/boardView");

	   	}
	 }
}