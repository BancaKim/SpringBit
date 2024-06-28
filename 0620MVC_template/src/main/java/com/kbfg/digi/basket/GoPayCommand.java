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
public class GoPayCommand implements Command {
	
	@Autowired BasketDAO basketdao;
	@Autowired BoardBean boarddata;
	
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
	   	
	   	try{
   			String user_id = (String)session.getAttribute("user_id");
   			HashMap<String, Integer> finalMap = (HashMap<String, Integer>) session.getAttribute("itemMap");
   			
   			for (Entry<String, Integer> entry : finalMap.entrySet()) {
				basketdao.payItem(user_id, entry.getKey(),entry.getValue());
			}
				session.removeAttribute("itemMap");
				System.out.println("아이템 구매완료");
				model.addAttribute("nextPage","basket/setProduct");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}