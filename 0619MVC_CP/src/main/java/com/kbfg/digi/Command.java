package com.kbfg.digi;

import org.springframework.ui.Model;

public interface Command {

	void execute(Model model);
	
}
