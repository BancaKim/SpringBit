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
public class BModifyCommand implements Command {
	
	@Autowired BoardDAO boarddao;
	@Autowired BoardBean boarddata;

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
	
	Map<String, Object> map = model.asMap();
	HttpServletRequest request = (HttpServletRequest) map.get("request");
	
	int num=Integer.parseInt(request.getParameter("num"));
		
	try {
		boarddata=boarddao.getDetail(num);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		if(boarddata==null){
		   	System.out.println("�ҷ����� ����");
			model.addAttribute("nextPage","redirect:list");
		}
		System.out.println("�ҷ����� ����");
		
		model.addAttribute("boarddata", boarddata);
		model.addAttribute("nextPage","board/boardModifyWrite");
		}
	}