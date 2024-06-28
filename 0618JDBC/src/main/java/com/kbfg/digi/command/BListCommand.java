package com.kbfg.digi.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.kbfg.digi.dao.BDao;
import com.kbfg.digi.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		System.out.println("BCommand"+dtos);
		model.addAttribute("list",dtos);
		

	}

}
