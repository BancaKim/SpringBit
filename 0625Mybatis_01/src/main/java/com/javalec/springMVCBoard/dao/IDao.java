package com.javalec.springMVCBoard.dao;

import java.util.ArrayList;

import com.javalec.springMVCBoard.dto.BDto;

public interface IDao {
	int maxCount();
	void write(String bName, String bTitle, String bContent, int maxCount);
	ArrayList<BDto> list();
	BDto contentView(int strId);
	void modify(int bId, String bName, String bTitle, String bContent);
	void delete(int bId);
	BDto reply_view(int bId);
	void reply(int bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent);
	void replyShape(String strGroup, String strStep);
	void upHit(int bId);
	
}