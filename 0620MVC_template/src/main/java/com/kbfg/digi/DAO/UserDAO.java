package com.kbfg.digi.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kbfg.digi.DTO.UserBean;

@Component
public class UserDAO {   
	JdbcTemplate template;
	
	@Autowired
	public UserDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	public boolean isUser(String user_id, String user_pw) {

	    String sql = "SELECT COUNT(*) FROM USER WHERE user_id=? AND user_pw=?";
		int result=0;

        try {
		result = template.queryForObject(sql, Integer.class, user_id, user_pw);
		System.out.println("result:"+result);
        } catch (EmptyResultDataAccessException e) {
            return false;
       }
        System.out.println("result:" + result);
        return result > 0;
    }
	
	public boolean hasUser(String user_id) {
		String sql = "SELECT COUNT(*) FROM USER WHERE USER_ID=?";
		int result=0;
		
		try {
		result = template.queryForObject(sql, Integer.class, user_id);
		 } catch (EmptyResultDataAccessException e) {
            return false;
        }
	        
		System.out.println("result:"+result);
        return result > 0;
    }
	
	public boolean insertUser(UserBean userdata) {

		String sql = "insert into user(user_id,user_pw,email,user_name,ssn,introduction) values(?,?,?,?,?,?)";
		int result = 0;

		result = template.update(sql,userdata.getUser_id(),userdata.getUser_pw(),userdata.getEmail(),userdata.getUser_name(),userdata.getSsn(),userdata.getIntroduction());
			
		System.out.println("result:"+result);
		
		 return result > 0;
	}

    public UserBean getUserData(String user_id) {
        System.out.println("°ÙÀ¯Àúµ¥ÀÌÅÍ µé¾î¿È");
        String sql = "SELECT * FROM user WHERE user_id = ?";
        
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper(UserBean.class), user_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int getUserCount() {
        String sql = "SELECT COUNT(*) FROM user";
        try {
            return template.queryForObject(sql, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

    public List<UserBean> getUserList(int page, int limit) {
        String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER() rnum, user_id, user_pw, email, user_name, ssn, introduction FROM (SELECT * FROM user ORDER BY user_id) AS s) AS u WHERE rnum >= ? AND rnum <= ?";
        int startrow = (page - 1) * 10 + 1;
        int endrow = startrow + limit - 1;
        return template.query(sql, new BeanPropertyRowMapper(UserBean.class), startrow, endrow);
    }

    public UserBean getDetail(String user_id) {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper(UserBean.class), user_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public boolean userDelete(String user_id) {
        String sql = "DELETE FROM user WHERE user_id = ?";
        int result = template.update(sql, user_id);
        return result > 0;
    }
}