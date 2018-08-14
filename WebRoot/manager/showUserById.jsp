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
    
    <title>My JSP 'showUserById.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function goUpdateUser(newsId){
			location.href="/test/manager/showUpdateUser.jsp?id=" + newsId;
			}
	    </script>

  </head>
  
  <body>
    <%
    request.setCharacterEncoding("utf-8");
    
    String strId=request.getParameter("id");
    int id=0;
    if(strId != null && !strId.equals(""))
    {
    id=Integer.parseInt(strId);
    }
 
     %>
     <%
     usersService service=new usersService();
     
     users news=service.getUser(id);
     
      %>			
     <h1 align="center">详细信息</h1>
     <hr />
          
            <center>id：<%=news.getId()%></center></br>
          	<center>用户名：<%=news.getUsername()%></center></br>       
          	<center>性别：<%=news.getSex() %></center></br>
	     	<center> 年龄：<%=news.getAge() %></center></br>
	    
	<h3 align="center"><a href="javascript:goUpdateUser(<%=news.getId() %>)">修改</a></h3>
  </body>
</html>
