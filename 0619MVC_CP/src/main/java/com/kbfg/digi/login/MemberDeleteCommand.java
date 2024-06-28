package com.kbfg.digi.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kbfg.digi.Command;
import com.kbfg.digi.DAO.UserDAO;
import com.kbfg.digi.DTO.UserBean;

@Service 
public class MemberDeleteCommand implements Command {
	
	@Autowired UserDAO userdao;
	@Autowired UserBean userdata;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
 	
		String user_id=(String)request.getParameter("user_id");
	   	boolean result=false;
	   	
	   	UserDAO userdao=new UserDAO();
	   	
	   	result=userdao.userDelete(user_id);
	   	if(result==false){
	   		System.out.println("유저 삭제 실패");
			model.addAttribute("nextPage", "redirect:/login/memberList");
	   	} else {
	   		System.out.println("유저 삭제 성공");
			model.addAttribute("nextPage", "redirect:/login/memberList");
	   	}
	}
}