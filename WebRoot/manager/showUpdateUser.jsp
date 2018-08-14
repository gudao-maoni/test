<%@page import="com.sict.test.entity.users"%>
<%@page import="com.sict.test.service.usersService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showUpdateUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
		request.setCharacterEncoding("utf-8");

		String strId = request.getParameter("id");
		int id = 0;
		if (strId != null) {
			id = Integer.parseInt(strId);
		}

		usersService service = new usersService();

		users news = service.getUser(id);
	%>
	<form action="/test/DoUpdateUser?id=<%=news.getId()%>" method="post">
    			<table align="center">

				<tr>
					<td>序号</td>
					<td><%=news.getId()%>
					</td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username">
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="text" name="sex">
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age">
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input type="submit" value="重新提交">                 
					</td>
				</tr>
			</table>
    		</form>
  </body>
</html>
