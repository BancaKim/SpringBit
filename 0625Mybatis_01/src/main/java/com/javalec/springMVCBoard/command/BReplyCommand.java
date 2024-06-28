package com.javalec.springMVCBoard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.springMVCBoard.dao.IDao;

@Service
public class BReplyCommand implements BCommand {
	
	private final SqlSession sqlSession;

	@Autowired
	public BReplyCommand(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {
		IDao idao = sqlSession.getMapper(IDao.class);

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
//		BDao dao = new BDao();
		idao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
		
	}

}
