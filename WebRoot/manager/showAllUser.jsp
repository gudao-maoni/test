<%@ page import="com.sict.test.service.usersService"%>
<%@ page import="com.sict.test.entity.users"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAllUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	
	<script type="text/javascript">
		function deleteusers(newsId){
			var result = confirm("确定删除？");
			if(result==true){
				//alert("删除");
				location.href="/test/DoDeleteUserById?id=" + newsId;
			}
		}
</script>
  </head>
  
  <body>
    <h4><a href="/test/manager/showAddUser.jsp">添加用户</a></h4>
    <center>按条件查询</center>
  <table align="center" border="1" cellspacing="0">
		<tr>
		    <td>序号</td>
			<td>用户名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>to be</td>
			<td>not to be</td>
		</tr>
         <%
    		usersService service = new usersService();
			 Object o= session.getAttribute("");
    		  if(o!=null){
    			List<users> list=(List<users>) o;
    			for(int i=0;i<list.size();i++){
    				users users=list.get(i);
      			}
    		}
    		
    int pageSize=3;
    int pageNo=1;
    int recordCount=service.allCountUser();
    int pageCount=(int)Math.ceil(recordCount*1.0/pageSize);
    String userPageNo=request.getParameter("pNo");
    if(userPageNo!=null){
        pageNo=Integer.parseInt(userPageNo);
    }
    
			ArrayList<users> list = service.getAllUserByPage(pageSize, pageNo);
			for (int i = 0; i < list.size(); i++) {
				users users = list.get(i);
				if(i%2==0){
		 %>
        <tr class="even">
        <%
         }else{
        %>
        <tr class="odd">
        <%
        }
        %>
        <td><%=i + 1%></td>
        <td><%=users.getUsername()%></td>
        <td><%=users.getSex()%></td>
        <td><%=users.getAge()%></td>
        <td><a href="/test/manager/showUserById.jsp?id=<%=users.getId()%>">详细</a></td>
        <td><a href="JavaScript:deleteusers(<%=users.getId()%>)">删除</a></td>
        </tr>
        <% 
        } 
        %>
       
		
</table>
 <div>
        <%
        if(pageNo>1){
         %>
        <center><a href="/test/manager/showAllUser.jsp?pNo=<%= pageNo-1%>">上一页</a></center>
        <%} %>
        <%if(pageNo<pageCount)
        {%>
        <center><a href="/test/manager/showAllUser.jsp?pNo=<%= pageNo+1%>">下一页</a></center>
        <%}%>
        </div>
  </body>
</html>
