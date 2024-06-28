package com.kbfg.digi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.kbfg.digi.DTO.UserBean;

@Component
public class UserDAO {   
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	UserBean user;
	
	public UserDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");

		} catch(Exception ex) {
			System.out.println(ex);
			return;
		}
	}
	
	public boolean isUser(String user_id, String user_pw) {
		System.out.println("isuser µé¾î¿È");
		String sql = "SELECT USER_ID, USER_PW FROM USER WHERE USER_ID=? AND USER_PW=?";
		int result=0;

		try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user_id);
		pstmt.setString(2, user_pw);

		 rs= pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			} else {
				result = 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException ex) {
		}
		if(con != null)
			try {
				con.close();
			} catch(SQLException ex) {
				
		}
		}
		if (result != 0) {
		return true;
		} else {
		return false;
		}
	}
	
	public boolean hasUser(String user_id) {
		String sql = "SELECT USER_ID FROM USER WHERE USER_ID=?";
		int result=0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			} else {
				result = 0;
			}
			
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
			}
			if (result == 1) {
			return true;
			} else {
			return false;
			}
		}
	
	public boolean insertUser(UserBean userdata) {

		String sql = "insert into user(user_id,user_pw,email,user_name,ssn,introduction) values(?,?,?,?,?,?)";
		int result = 0;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userdata.getUser_id());
			System.out.println("userid"+userdata.getUser_id());
			pstmt.setString(2, userdata.getUser_pw());
			System.out.println("userpw:"+userdata.getUser_pw());
			pstmt.setString(3, userdata.getEmail());
			System.out.println("email:"+userdata.getEmail());
			pstmt.setString(4, userdata.getUser_name());
			System.out.println("user_name:"+userdata.getUser_name());
			pstmt.setString(5, userdata.getSsn());
			System.out.println("ssn:"+userdata.getSsn());
			pstmt.setString(6, userdata.getIntroduction());
			System.out.println("introduction:"+userdata.getIntroduction());

			result = pstmt.executeUpdate();
		System.out.println("result:"+result);
		
		} catch (Exception ex) {
			System.out.println("userInsert : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}
		if (result == 0)
			return false;

		return true;
	}
	
	public UserBean getUserData(String user_id) {
		System.out.println("°ÙÀ¯Àúµ¥ÀÌÅÍ µé¾î¿È");
		String user_sql = "select * from user where user_id=?"; 
		
		try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(user_sql);
		pstmt.setString(1, user_id);
		rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new UserBean();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pw(rs.getString("user_pw"));
				user.setEmail(rs.getString("email"));
				user.setUser_name(rs.getString("user_name"));
				user.setSsn(rs.getString("ssn"));
				user.setIntroduction(rs.getString("introduction"));
			}

		} catch (Exception ex) {
			System.out.println("getBoardList  — Ÿ¬ : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}
		return user; 
	}

	public int getUserCount() {
		int x = 0;

		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement("select count(*) from user");
			System.out.println("rsÀü:");
			rs = pstmt.executeQuery();
			System.out.println("rsÈÄ:");
			if (rs.next()) {
				x = rs.getInt(1);
				System.out.println("x:"+x);	
			}
		} catch (Exception ex) {
			System.out.println("getUserCount : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}
		return x;
	}
	

	public List getUserList(int page, int limit) {
		String user_list_sql = "select * from "
				+ "(select row_number() over() rnum,user_id,user_pw,email,"
				+ "user_name,ssn,introduction from "
				+ "(select * from user order by user_id) AS s)AS u "
				+ "where rnum>=? and rnum<=?"; 

		List list = new ArrayList();

		int startrow = (page - 1) * 10 + 1; 
		int endrow = startrow + limit - 1;
		try {
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(user_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserBean user = new UserBean();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pw(rs.getString("user_pw"));
				user.setEmail(rs.getString("email"));
				user.setUser_name(rs.getString("user_name"));
				user.setSsn(rs.getString("ssn"));
				user.setIntroduction(rs.getString("introduction"));
				list.add(user);
			}

		} catch (Exception ex) {
			System.out.println("getUserList : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}
		return list; 
	}
	
	public UserBean getDetail(String user_id) throws Exception {
		UserBean user = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select * from user where user_id = ?");
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new UserBean();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pw(rs.getString("user_pw"));
				user.setEmail(rs.getString("email"));
				user.setUser_name(rs.getString("user_name"));
				user.setSsn(rs.getString("ssn"));
				user.setIntroduction(rs.getString("introduction"));
			}
			return user;
		} catch (Exception ex) {
			System.out.println("getDetail : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}
		return null;
	}

	public boolean userDelete(String user_id) {

		String user_delete_sql = "delete from user where user_id=?";

		int result = 0;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(user_delete_sql);
			pstmt.setString(1, user_id);
			result = pstmt.executeUpdate();
			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("userDelete: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
			}
			if(con != null)
				try {
					con.close();
				} catch(SQLException ex) {
					
			}
		}

		return false;
	}
}