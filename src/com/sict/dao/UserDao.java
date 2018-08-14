package com.sict.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sict.test.dao.BaseDao;
import com.sict.test.entity.users;

public class UserDao {
	//查询
	public ArrayList<users> select(){
		Connection con=BaseDao.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		ArrayList<users> list = null;
		if(con==null){
			return null;
		}else{
			
			try {
				String sql ="select * from users order by id desc";
				stmt=con.prepareStatement(sql);
				rs=stmt.executeQuery();
				
				if(rs != null){
					list = new ArrayList<users>();
					while (rs.next()) {
						users users = new users();
						
						users.setId(rs.getInt("id"));
						users.setUsername(rs.getString("username"));
						users.setSex(rs.getString("sex"));
						users.setAge(rs.getString("age"));
						

						list.add(users);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} finally {
				BaseDao.close(rs);
				BaseDao.close(stmt);
				BaseDao.close(con);
			}
		}
		return list;
	}
	//id查询
	public users select(int id){
		Connection con=BaseDao.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		users news =null;
		if(con==null){
			return null;
		}else{
			
			try {
				String sql="select * from users where id=?";
				stmt =con.prepareStatement(sql);
				
				stmt.setInt(1, id);
				rs=stmt.executeQuery();
				if(rs!=null&&rs.next()){
					news=new users();
					news.setId(rs.getInt("id"));
					news.setUsername(rs.getString("username"));
					news.setSex(rs.getString("sex"));
					news.setAge(rs.getString("age"));					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{
				BaseDao.close(rs);
				BaseDao.close(stmt);
				BaseDao.close(con);
			}
		}		
		return news;
	}
	//增加
	public boolean insert(users news){
		Connection con=BaseDao.getConnection();
		PreparedStatement stmt=null;
		if(con==null){
			return false;
		}else{
		
			try {
				String sql="insert into users (id,username,sex,age)" +
						" values(?,?,?,?)";
				stmt=con.prepareStatement(sql);
				
				stmt.setInt(1, news.getId());
				stmt.setString(2,news.getUsername());
				stmt.setString(3, news.getSex());
				stmt.setString(4,news.getAge());
				
				
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				BaseDao.close(stmt);
				BaseDao.close(con);	
			}	
		}
		return true;
	}
	//删除
	public boolean delete(int id ){
		Connection con=BaseDao.getConnection();
		PreparedStatement stmt=null;
		if(con==null){
			return false;
		}else{
			try {
				System.out.println("死在这里了");
				String sql="delete from users where id=?";
				stmt=con.prepareStatement(sql);
				stmt.setInt(1, id);
				System.out.println("如果我出来就好了");
				
				
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				BaseDao.close(stmt);
				BaseDao.close(con);
			}
		}
		
		return true;
	}
	//修改
	public boolean update(users news){
		Connection con=BaseDao.getConnection();
		PreparedStatement stmt=null;
		if(con==null){
			return false;
		}else{
			
			try {
				String sql="update users set username=?,sex=?,age=? where id=?";
				stmt=con.prepareStatement(sql);
				
				
				stmt.setString(1,news.getUsername());
				stmt.setString(2,news.getSex());
				stmt.setString(3,news.getAge());
				stmt.setInt(4,news.getId());
				
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally{
				BaseDao.close(stmt);
				BaseDao.close(con);
			}	
		}
		return true;
	}
	//分页查询
	public ArrayList<users> select(int pageSize,int pageNo){
		Connection con=BaseDao.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		ArrayList<users> list = null;
		if(con==null){
			return null;
		}else{
			
			try {
				System.out.println("我又要死了");
		//sql server 分页查询语句		
	/*
	 * select top "+pageSize+" * from users where id not in(select top "
						+ (pageNo-1)*pageSize+"  from users order by age desc)order by age desc
	 * */
		//mysql分页查询语句
	String sql =" select * from (users)  limit "+ (pageNo-1)*pageSize+","+pageSize+"";
				stmt=con.prepareStatement(sql);
				rs=stmt.executeQuery();
				System.out.println("我还能活吗");
				
				if(rs != null){
					list = new ArrayList<users>();
					while (rs.next()) {
						users user = new users();
						
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
				        user.setSex(rs.getString("sex"));
				        user.setAge(rs.getString("age"));
						

						list.add(user);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} finally {
				BaseDao.close(rs);
				BaseDao.close(stmt);
				BaseDao.close(con);
			}
		}
		return list;
	}
	//查询个数
	public int allCountUser(){
		Connection con = BaseDao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		users user =null;
		int num=0;
		if(con == null){
			return num;
		}else{
			try {
				String sql = "select count(*) from users";
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();				
				if(rs!=null&&rs.next()){
					num = rs.getInt(1);			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}finally{
				BaseDao.close(rs);
				BaseDao.close(stmt);
				BaseDao.close(con);
			}
		}
		return num;
	}
}
