package com.javalec.springMVCBoard.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.springMVCBoard.dao.IDao;

@Service
public class BListCommand implements BCommand {
	
	private final SqlSession sqlSession;
	
	@Autowired
	public BListCommand(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {
		IDao idao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", idao.list());
	}
}