package com.sict.test.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sict.test.entity.users;
import com.sict.test.service.usersService;

public class DoAddUser extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		
			throws ServletException, IOException {

		response.setContentType("utf-8");
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		
		HttpSession session=request.getSession();
		Object name = session.getAttribute("username");	
			
		if ( username != null
					&& !username.equals("") && sex != null
					&& !sex.equals("") && age != null
					&& !age.equals("")) {
				users news = new users();
				
				news.setUsername(username);
				news.setSex(sex);
				news.setAge(age);

				usersService service = new usersService();
				ArrayList list = service.pubNews(news);
			
			System.out.println("这是前面");
			request.getRequestDispatcher("/manager/showAllUser.jsp").forward(request,response);
			System.out.println("这是后面");
		}
		
	}
	
}

