package com.kbfg.digi.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kbfg.digi.Command;
import com.kbfg.digi.DAO.BoardDAO;

@Service 
public class BListCommand implements Command {
	
	@Autowired
	BoardDAO boarddao;
	
	@Override
	public void execute(Model model) {
		
//		BoardDAO boarddao = new BoardDAO();
		List boardlist=new ArrayList();
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount=boarddao.getListCount(); 
		boardlist = boarddao.getBoardList(page,limit); 
		
		int maxpage=(int)((double)listcount/limit+0.95); 
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1;
   		
   		model.addAttribute("page", page);		
   		model.addAttribute("maxpage", maxpage); 
   		model.addAttribute("startpage", startpage);
   		model.addAttribute("endpage", endpage);     
   		model.addAttribute("listcount",listcount); 
   		model.addAttribute("boardlist", boardlist);

	 }
 }