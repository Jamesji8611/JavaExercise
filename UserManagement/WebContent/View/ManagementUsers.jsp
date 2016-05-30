<%@page import="com.userManagement.Model.UsersBeanProcess"%>
<%@page import="com.userManagement.Model.UsersBean"%>
<%@page import="com.userManagement.Control.logincheck" %>
<%@page import="java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%	
	logincheck.checkTimeout(request, response);
	UsersBean ub = null;
	int pageNow = request.getParameter("pageNow")!=null?Integer.parseInt(request.getParameter("pageNow")):0;
	int pageCount = Integer.parseInt( request.getAttribute("pageCount").toString() );
	ArrayList<UsersBean> al = (ArrayList<UsersBean>)request.getAttribute("UsersData");
	
	String[] color = {"pink","silver"}; 
	
%>
</head>
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
			<td width="75%" style="background-image:url(<%=request.getContextPath()%>/images/Christmas.jpg);width:1080px;height:500px;">
				<center>
					<h1>Manage Users</h1>
					<table border='1'>
						<tr><th>UserID</th><th>UserName</th><th>Passwd</th><th>Email</th><th>CustomLevel</th><th>Management</th></tr>
						<% for(int i=0; i<al.size(); i++){ 
							ub = al.get(i);
						%>
						<tr bgcolor="<%=color[i%2]%>">
							<td width="8%"><%=ub.getId() %></td>
							<td width="13%"><%=ub.getName() %></td>
							<td width="13%"><%=ub.getPasswd() %></td>
							<td width="32%"><%=ub.getEmail() %></td>
							<td width="8%"><%=ub.getUserlevel() %></td>
							<td width="6%"><a href="<%=request.getContextPath()%>/MVC/UsersData?OpFlag=queryuser&ID=<%=ub.getId() %>&pageNow=<%=pageNow%>">Management</a></td>
						</tr>
						<%} %>
					</table>
					<br>
					<%if(pageNow+1 != 1){%>
					<a href="<%=request.getContextPath()%>/MVC/UsersData?pageNow=0&OpFlag=allusers"><1</a>
					<a href="<%=request.getContextPath()%>/MVC/UsersData?pageNow=<%=pageNow-1 %>&OpFlag=allusers">Last Page</a>
					<%}
					for(int i=pageNow+1; i<=((pageNow+8)<=pageCount?(pageNow+8):pageCount); i++){ 
						if(pageNow == (i-1)){%>
							<a href="<%=request.getContextPath()%>/MVC/UsersData?pageNow=<%=i-1 %>&OpFlag=allusers"><b><%=i %></b></a>
						<%}else{ %>
							<a href="<%=request.getContextPath()%>/MVC/UsersData?pageNow=<%=i-1 %>&OpFlag=allusers"><%=i %></a>
						<%} %>
					<%}
					if(pageNow+1 != pageCount){%>
					<a href="<%=request.getContextPath()%>/MVC/UsersData?pageNow=<%=pageNow+1 %>&OpFlag=allusers">Next Page</a>
					<a href="<%=request.getContextPath()%>/MVC/UsersData?pageNow=<%=pageCount-1 %>&OpFlag=allusers">><%=pageCount %></a>
					<%} %>
				</center>
			</td>
		</tr>
	</table>
</body>
</html>