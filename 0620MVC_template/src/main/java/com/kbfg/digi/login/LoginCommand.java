package com.kbfg.digi.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.kbfg.digi.Command;
import com.kbfg.digi.DAO.UserDAO;

@Component
public class LoginCommand implements Command{

	private final UserDAO userDao;
	
	@Autowired
	public LoginCommand(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		Boolean isUser = userDao.isUser(user_id, user_pw);

		if(isUser==false) {
			model.addAttribute("message", "로그인 실패!");
			model.addAttribute("nextPage", "redirect:loginForm");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user_id);
			session.setMaxInactiveInterval(60 * 30);
				if (user_id.equals("admin") && user_pw.equals("1234")) {
				model.addAttribute("message", "로그인 성공");
				model.addAttribute("nextPage", "redirect:home");
			} else {
				model.addAttribute("message", "로그인 성공");
				model.addAttribute("nextPage", "redirect:home");
				}
			}
		}
	}
