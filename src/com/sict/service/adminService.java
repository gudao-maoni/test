package com.sict.test.service;

import com.sict.test.dao.AdminDao;
import com.sict.test.entity.admin;

public class adminService {
	
	private AdminDao adminDao=new AdminDao();
	
	public boolean login(admin username){
		boolean isLogin = adminDao.login(username); 
		return isLogin; 		
	}

}
