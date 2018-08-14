package com.sict.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sict.test.dao.BaseDao;
import com.sict.test.entity.admin;

public class AdminDao {
	public boolean login(admin username){
		Connection con =BaseDao.getConnection();
		PreparedStatement stmt =null;
		if(con==null){
			return false;
		}else{
			
			try {
				String sql="select * from ad where username=? and password=?";
				stmt=con.prepareStatement(sql);
				stmt.setString(1,username.getUsername());
				stmt.setString(2,username.getPassword());
				System.out.println(1);
				System.out.println(2);
				
				stmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				BaseDao.close(stmt);
				BaseDao.close(con);
			}			
		}
		return false;		
	}

}
