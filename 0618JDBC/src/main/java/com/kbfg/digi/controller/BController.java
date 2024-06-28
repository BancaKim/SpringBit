package com.kbfg.digi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kbfg.digi.command.BCommand;
import com.kbfg.digi.command.BListCommand;
import com.kbfg.digi.util.Constant;

@Controller
public class BController {

		BCommand command = null;
		
		private JdbcTemplate template;
		
		@Autowired
		public void setTemplate(JdbcTemplate template) {
			this.template = template;
			Constant.template = this.template;  //BController�� �ƴ� ��𿡼��� �� �� �ְԲ� �Ϸ��� �־��ִ°�
		}
		
		@RequestMapping("/list")
		public String list(Model model) {
			System.out.println("list()");
			command = new BListCommand();
			
			command.execute(model);
			System.out.println("execute()");
			return "list";
		}
}
