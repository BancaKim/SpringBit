package com.kbfg.digi.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kbfg.digi.dto.BDto;
import com.kbfg.digi.util.Constant;

public class BDao {
	JdbcTemplate template;
	
	public BDao() {
		this.template = Constant.template;
	}
	
	public ArrayList<BDto> list(){
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		System.out.println("BDTo");
		String query = "SELECT bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent "+
						"FROM mvc_board ORDER BY bGroup desc, bStep asc";
		
		return (ArrayList<BDto>)template.query(query,new BeanPropertyRowMapper<BDto>(BDto.class));
	}
}
