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
public class MemberViewCommand implements Command {
	
	@Autowired UserDAO userdao;
	@Autowired UserBean userdata;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
 	
		String user_id=(String)request.getParameter("user_id");
	   	try {
			userdata=userdao.getDetail(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   	
	   	if(userdata==null){
	   		System.out.println("해당 회원 없습니다");
			model.addAttribute("nextPage", "login/memberList");
	   	}else {
	   	System.out.println("조회완료");
	   	
	   	model.addAttribute("userdata",userdata);
		model.addAttribute("nextPage", "login/memberInfo");
	   	}
	 }
}