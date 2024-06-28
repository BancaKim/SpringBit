package com.javalec.springMVCBoard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.springMVCBoard.dao.IDao;
import com.javalec.springMVCBoard.util.Constant;

@Service
public class BContentCommand implements BCommand {

	private final SqlSession sqlSession;

	@Autowired
	public BContentCommand(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {
		IDao idao = sqlSession.getMapper(IDao.class);

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int bId = Integer.parseInt(request.getParameter("bId"));
	
		idao.upHit(bId);
		model.addAttribute("content_view", idao.contentView(bId));
		
	}

}
