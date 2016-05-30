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
					<h1>Add Users</h1>
					<form action="<%=request.getContextPath()%>/MVC/UsersData?OpFlag=adduser" name="AddUserform" method="post">
					<table border='1'>
						<tr><td width="20%">User Name</td><td width="50%"><input type="text" name="username" size="30"></td></tr>
						<tr><td width="20%">Password</td><td width="50%"><input type="text" name="passwd" size="20"></td></tr>
						<tr><td width="20%">Email</td><td width="50%"><input type="text" name="email" size="50"></td></tr>
						<tr><td width="20%">Custom Level</td><td width="50%"><input type="text" name="customlevel" size="10"></td></tr>
						<tr>
							<td colspan="2"><table align="center" width="100%">
								<tr width="100%">
									<td width="30%" align="center"><input type="submit" value="Add"></td>
									<td width="30%" align="center"><input type="reset" value="Reset"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					</form>
				</center>
			</td>
		</tr>
	</table>
	<hr>
</body>
</html>