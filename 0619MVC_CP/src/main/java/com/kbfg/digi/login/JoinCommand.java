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
   			System.out.println("�ߺ��Ǵ� ���̵� �ֽ��ϴ�.");
			model.addAttribute("message", "�ߺ� ���̵� ����");
			model.addAttribute("nextPage", "redirect:joinForm");
   		}
   		
   		boolean result2 = userDao.insertUser(userdata);
   		
   		if(result2 == true) {

	   		System.out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
	   		HttpSession session = request.getSession();
	   		session.setAttribute("user_id",userdata.getUser_id());
			model.addAttribute("message", "ȸ������ ����");
			model.addAttribute("nextPage", "redirect:home");	   		
   		}
   		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}  	
}
