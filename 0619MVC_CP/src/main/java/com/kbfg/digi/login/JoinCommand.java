package com.kbfg.digi.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.kbfg.digi.Command;
import com.kbfg.digi.DAO.UserDAO;
import com.kbfg.digi.DTO.UserBean;

public class JoinCommand implements Command{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		UserBean userdata=new UserBean();
		UserDAO userDao = new UserDAO();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
   		try{
   			userdata.setUser_id(request.getParameter("user_id"));
   			userdata.setUser_pw(request.getParameter("user_pw"));
	   		userdata.setEmail(request.getParameter("email"));
	   		userdata.setUser_name(request.getParameter("user_name"));
	   		userdata.setSsn(request.getParameter("ssn"));
	   		userdata.setIntroduction(request.getParameter("introduction"));
	   		
   		boolean result = userDao.hasUser(userdata.getUser_id());

   		if(result == true){
   			System.out.println("중복되는 아이디가 있습니다.");
			model.addAttribute("message", "중복 아이디 존재");
			model.addAttribute("nextPage", "redirect:joinForm");
   		}
   		
   		boolean result2 = userDao.insertUser(userdata);
   		
   		if(result2 == true) {

	   		System.out.println("회원가입에 성공하였습니다.");
	   		HttpSession session = request.getSession();
	   		session.setAttribute("user_id",userdata.getUser_id());
			model.addAttribute("message", "회원가입 성공");
			model.addAttribute("nextPage", "redirect:home");	   		
   		}
   		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}  	
}
