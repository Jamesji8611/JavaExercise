<%@page import="com.userManagement.Model1.UsersBeanProcess"%>
<%@page import="com.userManagement.Model1.UsersBean"%>
<%@page import="java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	UsersBeanProcess ubp = new UsersBeanProcess();
	int rowsPage = ubp.getRowspage();
	int pageCount = ubp.getPageCount();
	UsersBean ub = null;
	int pageNow = request.getParameter("pageNow")!=null?Integer.parseInt(request.getParameter("pageNow")):0;
	ArrayList<UsersBean> al = new ArrayList<UsersBean>();
	al = ubp.showUsers(pageNow);
%>
</head>
<body>
	<table width="100%">
		<tr>
			<td width="120" length="180"><img src="<%=request.getContextPath()%>/images/003.gif" width="117" length="175"></td>
			<td align="left">Welcome, <%=request.getSession().getAttribute("UserName").toString() %></td>
		</tr>
	</table>
	<hr>
	<center>
	<h1>Manage Users</h1>
	<table border='1'>
		<tr><th>UserID</th><th>UserName</th><th>Passwd</th><th>Email</th><th>CustomLevel</th><th>Management</th></tr>
		<% for(int i=0; i<al.size(); i++){ 
			ub = al.get(i);
		%>
		<tr>
			<td><%=ub.getId() %></td>
			<td><%=ub.getName() %></td>
			<td><%=ub.getPasswd() %></td>
			<td><%=ub.getEmail() %></td>
			<td><%=ub.getUserlevel() %></td>
			<td><a href="<%=request.getContextPath()%>/Model1/UpdateUsers.jsp?ID=<%=ub.getId() %>&pageNow=<%=pageNow%>">Management</a></td>
		</tr>
		<%} %>
	</table>
	<br>
	<%if(pageNow+1 != 1){%>
	<a href="<%=request.getContextPath()%>/Model1/ManagementUsers.jsp?pageNow=0"><1</a>
	<a href="<%=request.getContextPath()%>/Model1/ManagementUsers.jsp?pageNow=<%=pageNow-1 %>">Last Page</a>
	<%}
	for(int i=pageNow+1; i<=((pageNow+8)<=pageCount?(pageNow+8):pageCount); i++){ %>
		<a href="<%=request.getContextPath()%>/Model1/ManagementUsers.jsp?pageNow=<%=i-1 %>"><%=i %></a>
	<%}
	if(pageNow+1 != pageCount){%>
	<a href="<%=request.getContextPath()%>/Model1/ManagementUsers.jsp?pageNow=<%=pageNow+1 %>">Next Page</a>
	<a href="<%=request.getContextPath()%>/Model1/ManagementUsers.jsp?pageNow=<%=pageCount-1 %>">><%=pageCount %></a>
	<%} %>
	</center>
</body>
</html>