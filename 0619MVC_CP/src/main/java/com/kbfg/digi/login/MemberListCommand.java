package com.kbfg.digi.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kbfg.digi.Command;
import com.kbfg.digi.DAO.UserDAO;

@Service 
public class MemberListCommand implements Command {
	
	@Autowired
	UserDAO userdao;
	
	@Override
	public void execute(Model model) {

		List userlist=new ArrayList();
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("getUserCount Àü");
		int listcount=userdao.getUserCount(); 
		System.out.println("listCount="+listcount);
		userlist = userdao.getUserList(page,limit); 
		
   		int maxpage=(int)((double)listcount/limit+0.95); 
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1;
   		
   		System.out.println("page:"+page);
   		System.out.println("maxpage:"+maxpage);
   		System.out.println("startpage:"+startpage);
   		System.out.println("endpage:"+endpage);
   		System.out.println("listcount:"+listcount);
   		System.out.println("userlist:"+userlist);

   		request.setAttribute("page", page);		
   		request.setAttribute("maxpage", maxpage); 
   		request.setAttribute("startpage", startpage);
   		request.setAttribute("endpage", endpage);     
		request.setAttribute("listcount",listcount); 
		request.setAttribute("userlist", userlist);
		
		model.addAttribute("nextPage", "login/memberList");
		
	 }
 }