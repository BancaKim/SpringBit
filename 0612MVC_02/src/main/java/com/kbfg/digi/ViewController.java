package com.kbfg.digi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class ViewController {

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String boardview() {
		return "/board/view";
	}
	

	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String boardcontent(Model model) {
		
		model.addAttribute("id",30);
		return "/board/content";
	}
	
	@RequestMapping("/reply")
	public ModelAndView boardReply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",500);  //model 값 입력
		mv.setViewName("board/reply");  //view 입력
		return mv;
	}
	
//	@RequestMapping("/checkId")
//	public String checkId(HttpServletRequest httpServletRequest, Model model) {
//		String id = httpServletRequest.getParameter("id");
//		String pw = httpServletRequest.getParameter("pw");		
//		model.addAttribute("identify", id);
//		model.addAttribute("password",pw);
//		return "/board/checkId";
//	}
//	
	@RequestMapping("/checkId")
	public String checkId(@RequestParam("id") String id,@RequestParam("pw") int pw, Model model) {		
		model.addAttribute("identify", id);
		model.addAttribute("password",pw);
		return "/board/checkId";
	}	
	@RequestMapping("/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "/board/confirmId";
	}

}
