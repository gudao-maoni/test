package com.sict.test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sict.test.entity.admin;
import com.sict.test.service.adminService;

public class DoLogin extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("utf-8");
	    
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    
	    if(username!=null&&!username.equals("")&&password!=null&&!password.equals(""))
	    {
	    adminService adminService=new adminService();
	    admin admin=new admin();
	    
	    admin.setUsername(username);
	    admin.setPassword(password);
	    
	    adminService.login(admin);
	    
	    
	    HttpSession session=request.getSession();
	    session.setAttribute("username", username);
	    
	    request.getRequestDispatcher("/manager/showAllUser.jsp").forward(request, response);
	    }else{
	    	request.getRequestDispatcher("first.jsp").forward(request, response);	  
	  }
	  
	    
	}

}
