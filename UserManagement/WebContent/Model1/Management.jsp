<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String u = request.getSession().getAttribute("UserName").toString();
%>
</head>
<body>
	<table width="100%">
		<tr>
			<td width="120" length="180"><img src="<%=request.getContextPath()%>/images/003.gif" width="117" length="175"></td>
			<td align="left">Welcome, <%=u %></td>
		</tr>
	</table>
	<hr>
	<center>
	<a href="<%=request.getContextPath() %>/Model1/ManagementUsers.jsp"><h2><b>Manage Users</b></h2></a><br>
	<a href="<%=request.getContextPath() %>/Model1/AddUsers.jsp"><h2><b>Add User</b></h2></a><br>
	<a href="<%=request.getContextPath() %>/Model1/QueryUsers.jsp"><h2><b>Query Users</b></h2></a><br>
	<a href="<%=request.getContextPath() %>/Model1/Login.jsp"><h2><b>Quit</b></h2></a><br>
	</center>
</body>
</html>