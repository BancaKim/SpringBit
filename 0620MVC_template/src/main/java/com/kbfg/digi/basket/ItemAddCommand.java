package com.kbfg.digi.basket;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kbfg.digi.Command;
import com.kbfg.digi.DAO.BasketDAO;
import com.kbfg.digi.DTO.BoardBean;

@Service
public class ItemAddCommand implements Command {
	
	@Autowired BasketDAO basketdao;
	@Autowired BoardBean boarddata;
	
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
	   	System.out.println("item addaction in execute");
	   	
	   	try{
   			String user_id = (String)session.getAttribute("user_id");
   			HashMap<String, Integer> finalMap = (HashMap<String, Integer>) session.getAttribute("itemMap");
   			if(finalMap==null){
   				finalMap= new HashMap<String, Integer>();
   			}
   			
   			if(!request.getParameter("apple_num").equals("")) {
   				finalMap.put(request.getParameter("apple"), Integer.parseInt(request.getParameter("apple_num")));
   			}
   			
   			if(!request.getParameter("peer_num").equals("")) {
   				finalMap.put(request.getParameter("peer"), Integer.parseInt(request.getParameter("peer_num")));
   			}
   			
   			if(!request.getParameter("mandarin_num").equals("")) {
   				finalMap.put(request.getParameter("mandarin"), Integer.parseInt(request.getParameter("mandarin_num")));
   				
   			}
	   		
   			int count = 0;
   			int result = 0;
   			
   			for (Entry<String, Integer> entry: finalMap.entrySet()){
	   		
   			if(basketdao.insertItem(user_id, entry.getKey(),entry.getValue())){
   				result++;
   				}
   	 		count ++;
   			}
   			
	   		if(result == count) {

		   		System.out.println("장바구니 추가에 성공하였습니다.");
		   		
		   		session.removeAttribute("itemmap");

	   			finalMap= new HashMap<String, Integer>();
		   		finalMap.put("사과", basketdao.getItem(user_id,"사과")) ;
		   		finalMap.put("배", basketdao.getItem(user_id,"배")) ;
		   		finalMap.put("귤", basketdao.getItem(user_id,"귤")) ;
		   		session.setAttribute("itemMap",finalMap);
		   		
		   		model.addAttribute("nextPage","/basket/confirmItem");
	   		}
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
	}  	
}