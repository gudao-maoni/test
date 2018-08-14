package com.sict.test.service;

import java.util.ArrayList;

import com.sict.test.entity.users;
import com.sict.test.dao.UserDao;


public class usersService {
	
	private UserDao newsDao =new UserDao();
	int pageSize =0;
	int pageNo =0;
	
	public ArrayList<users> getAllUser() {
		ArrayList<users> list =newsDao.select();

		return list;
	} 
	
	public ArrayList<users> pubNews(users news) {
		boolean isPub=newsDao.insert(news);
		ArrayList<users> list=newsDao.select();
		return list;

	}
	
	public ArrayList<users> delUser(int id) {
		boolean isDel=newsDao.delete(id);
		ArrayList<users> list=newsDao.select();
		
		return list;
	}
	
	public ArrayList<users> updateUser(users news,int oldId) {
		boolean isUpd=newsDao.update(news);
		ArrayList<users> list=newsDao.select();
		return list;

	}
	
	public users getUser(int id){
		users news =newsDao.select(id);
		
		return news;
		
	}
	
	
	
	public ArrayList<users> getAllUserByPage(int pageSize,int pageNo){
		ArrayList<users> list = newsDao.select(pageSize, pageNo);
		return list;
	}
	
	public int allCountUser(){
		int count = newsDao.allCountUser();
		return count;
	}
	
	

}
