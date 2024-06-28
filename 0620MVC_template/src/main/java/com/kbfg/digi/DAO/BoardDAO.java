package com.kbfg.digi.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kbfg.digi.DTO.BoardBean;

@Component
public class BoardDAO {
	JdbcTemplate template;
	
	@Autowired
	public BoardDAO(JdbcTemplate jdbcTemplate) {
		this.template = jdbcTemplate;
	}

	public int getListCount() {
		String sql = "select count(*) from board";
		return template.queryForObject(sql, Integer.class);
	}

	public List getBoardList(int page, int limit) {
		String query = "select * from "
				+ "(select row_number() over() rnum,BOARD_NUM,BOARD_NAME,BOARD_SUBJECT,"
				+ "BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,"
				+ "BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE from "
				+ "(select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc) AS s)AS u "
				+ "where rnum>=? and rnum<=?"; 

		int startrow = (page - 1) * 10 + 1; 
		int endrow = startrow + limit - 1;
		
		return (List<BoardBean>)template.query(query, new BeanPropertyRowMapper<BoardBean>(BoardBean.class),startrow, endrow);
		}
			
		
	public boolean boardInsert(BoardBean board) {
		int num = 0;
		int result = 0;

		String sql = "select max(board_num) from board";
		num = template.queryForObject(sql, Integer.class)+1;
		
		sql = "insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
		sql += "BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF," + "BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"
				+ "BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";

		result = template.update(sql, num, board.getBOARD_NAME(),board.getBOARD_PASS(),board.getBOARD_SUBJECT(),board.getBOARD_CONTENT(), board.getBOARD_FILE(),num,0,0,0);
		
		return result>0;
				}

	public boolean boardModify(BoardBean modifyboard) throws Exception {
		String sql = "update board set BOARD_SUBJECT=?,BOARD_CONTENT=? where BOARD_NUM=?";

		int result = 0;
		result = template.update(sql, modifyboard.getBOARD_SUBJECT(),modifyboard.getBOARD_CONTENT(),modifyboard.getBOARD_NUM());
		
		return result>0;
	}

	public boolean isBoardWriter(int num, String pass) {

		String sql = "select BOARD_PASS from board where BOARD_NUM=?";
		try {
		String dbPass = template.queryForObject(sql, String.class, num);
		return pass.equals(dbPass);
		} catch (Exception ex) {
			System.out.println("exception:"+ex);
			return false;
		}
	}

	public boolean boardDelete(int num) {
		String sql = "delete from board where BOARD_num=?";
		try {
			int result = template.update(sql,num);
			return result>0;
		}catch(Exception ex) {
			System.out.println("boardDelete:"+ex);
			return false;
			}
		}

	
	public void setReadCountUpdate(int num){
		String sql = "update board set BOARD_READCOUNT = BOARD_READCOUNT+1 where BOARD_NUM = ?";
		
		try {
			template.update(sql,num);
		} catch (Exception ex) {
			System.out.println("setReadCountUpdate : " + ex);
		}
	}

	public BoardBean getDetail(int num) {
		String sql ="select * from board where BOARD_NUM = ?";
		try {
		return template.queryForObject(sql, new BeanPropertyRowMapper(BoardBean.class),num);
		}catch(Exception ex) {
			System.out.println("ex:"+ex);
			return null;
		}
	}
	
	public int boardReply(BoardBean board) {
		String board_max_sql = "select max(board_num) from board";
		String update_seq_sql = "update board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? and BOARD_RE_SEQ>?";
		String insert_sql = "insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT, BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,sysdate())";
		
		try {
			Integer maxBoardNum = template.queryForObject(board_max_sql, Integer.class);
			int num = (maxBoardNum != null ? maxBoardNum : 0) + 1;
		    int re_ref = board.getBOARD_RE_REF();
            int re_lev = board.getBOARD_RE_LEV();
            int re_seq = board.getBOARD_RE_SEQ();
            
            template.update(update_seq_sql,re_ref,re_seq);
			re_seq = re_seq + 1;
			re_lev = re_lev + 1;

			template.update(insert_sql, num,board.getBOARD_NAME(),board.getBOARD_PASS(),board.getBOARD_SUBJECT(),board.getBOARD_CONTENT(),"",re_ref,re_lev,re_seq,0);
			
			return num;
		} catch (Exception ex) {
			System.out.println("boardReply : " + ex);
			return 0; 
			}
		}
	}