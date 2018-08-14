package com.sict.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sict.test.entity.users;
import com.sict.test.service.usersService;

public class DoUpdateUser extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		
		String strId = request.getParameter("id");
		int id = 0;
		if (strId != null && !strId.equals("")) {
		
			id = Integer.parseInt(strId);
			
		}
		
			users news=new users();
			
			news.setUsername(username);
			news.setSex(sex);
			news.setAge(age);
			news.setId(id);
			
			usersService service=new usersService();
			
			service.updateUser(news, id);
			
			request.getRequestDispatcher("/manager/showAllUser.jsp").forward(request,response);
			
	}

}