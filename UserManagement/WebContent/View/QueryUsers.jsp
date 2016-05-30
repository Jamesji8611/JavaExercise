<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.userManagement.Control.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	logincheck.checkTimeout(request, response);
%>
<body>
	<table width="100%">
		<tr>
			<td width="120" ><img src="<%=request.getContextPath()%>/images/003.gif" width="117"></td>
			<td align="left">Welcome, <%=request.getSession().getAttribute("UserName").toString() %></td>
			<td align="right"><%=request.getSession().getAttribute("MyLoginNum") %>th visitor</td>
		</tr>
	</table>
	<hr>
	<table border="1" width="100%" height="100%">
		<tr>
			<td width="15%">
				<table>
					<tr><td><h2><a href="<%=request.getContextPath() %>/View/Management.jsp">Menu</a></h2></td></tr>
					<tr><td><h2><a href="<%=request.getContextPath() %>/MVC/UsersData?pageNow=0&OpFlag=allusers">Manage Users</a></h2></td></tr>
					<tr><td><h2><a href="<%=request.getContextPath() %>/View/AddUsers.jsp?OpFlag=adduser">Add Users</a></h2></td></tr>
					<tr><td><h2><a href="<%=request.getContextPath() %>/View/QueryUsers.jsp?OpFlag=queryusers">Query Users</a></h2></td></tr>
					<tr><td><h2><a href="<%=request.getContextPath() %>/View/Login.jsp">Quit</a></h2></td></tr>
				</table>
			</td>
			<td width="75%">
				<center>
					<h1>Query Users</h1>
				</center>
			</td>
		</tr>
	</table>
</body>
</html>