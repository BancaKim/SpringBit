package com.kbfg.digi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kbfg.digi.Command;
import com.kbfg.digi.basket.GoPayCommand;
import com.kbfg.digi.basket.ItemAddCommand;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
@RequestMapping("/basket")
public class BasketController {

	Command command = null;
	@Autowired ItemAddCommand itemAddCommand;
	@Autowired GoPayCommand goPayCommand;
	
	@RequestMapping("/setProduct")
	public String setProduct(HttpServletRequest request, Model model) {
		System.out.println("setProduct()");

		String nextPage = "/basket/setProduct";
		return nextPage;
	}
	
	@RequestMapping("/itemAddAction")
	public String itemAddAction(HttpServletRequest request, Model model) {
		System.out.println("itemAddAction()");
		
		model.addAttribute("request", request);
		itemAddCommand.execute(model);
		
		Map<String, Object> map = model.asMap();
		String nextPage = (String) map.get("nextPage");
		return nextPage;
	}
	
	@RequestMapping("/goPayAction")
	public String goPayAction(HttpServletRequest request, Model model) {
		System.out.println("goPayAction()");
		
		model.addAttribute("request", request);
		goPayCommand.execute(model);
		
		Map<String, Object> map = model.asMap();
		String nextPage = (String) map.get("nextPage");
		return nextPage;
	}
}
