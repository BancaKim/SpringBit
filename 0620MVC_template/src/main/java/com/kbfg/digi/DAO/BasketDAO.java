package com.kbfg.digi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BasketDAO {  
	
	JdbcTemplate template;
	
	@Autowired
	public BasketDAO(JdbcTemplate template) {
		this.template =template;
	}
		
	 public boolean insertItem(String user_id, String item_name, int item_num) {
	        String sql = "SELECT item_num FROM basket WHERE user_id = ? AND item_name = ?";
	        String updateSql = "UPDATE basket SET item_num = ? WHERE user_id = ? AND item_name = ?";
	        String insertSql = "INSERT INTO basket (user_id, item_name, item_num) VALUES (?, ?, ?)";
	        
	        try {
	            Integer existingItemNum = template.queryForObject(sql, Integer.class, user_id, item_name);
	            
	            if (existingItemNum != null) {
	                int newItemNum = existingItemNum + item_num;
	                template.update(updateSql, newItemNum, user_id, item_name);
	            } else {
	                template.update(insertSql, user_id, item_name, item_num);
	            }
	            return true;
	        } catch (Exception ex) {
	            System.out.println("insertItem : " + ex);
	            return false;
	        }
	    }

    public int getItem(String user_id, String item_name) {
        String sql = "SELECT item_num FROM basket WHERE user_id = ? AND item_name = ?";
        
        try {
            return template.queryForObject(sql, Integer.class, user_id, item_name);
        } catch (Exception ex) {
            System.out.println("getItem : " + ex);
            return 0;
        }
    }
	
    public boolean payItem(String user_id, String item_name, int item_num) {
        String deleteSql = "DELETE FROM basket WHERE user_id = ? AND item_name = ?";
        String insertHistSql = "INSERT INTO hist_pay (user_id, item_name, item_num) VALUES (?, ?, ?)";
        
        try {
            int deleteResult = template.update(deleteSql, user_id, item_name);
            
            if (deleteResult > 0) {
                template.update(insertHistSql, user_id, item_name, item_num);
                return true;
            } else {
                System.out.println("payItem : No item found to delete");
                return false;
            }
        } catch (Exception ex) {
            System.out.println("payItem : " + ex);
            return false;
        }
    }
}