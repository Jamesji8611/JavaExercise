<%@page import="com.userManagement.Model1.UsersBeanProcess"%>
<%@page import="com.userManagement.Model1.UsersBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	int ID = Integer.parseInt(request.getParameter("ID"));
	UsersBeanProcess ubp = new UsersBeanProcess();
	UsersBean ub = ubp.queryUser(ID);
	int pageNow = Integer.parseInt(request.getParameter("pageNow"));
%>
<script type="text/javascript">
	function update(){
		var id = document.getElementsByName("ID");
		alert(id);
		
	}
	function delUser(){
		var id = document.getElementsByName("ID")[0].value;
		alert("ID="+id);
		alert("ID="+document.getElementById("ID").value);
		
		document.getElementsByName("Passwd")[0].innerHTML = "Hello";
		alert(1);
		var x = document.getElementById("Passwd");
		x.innerHTML ="Hello";
		alert(2);
	}
</script>
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
	<h1>Update Users</h1>
	<form action="" name="formuser">
	<table border="1" width="30%">
		<tr><td>UserID</td><td><input id="ID" name="ID" width="100%" type="text" readonly="readonly" value=<%=ID %>></td></tr>
		<tr><td>UserName</td><td><input id="name" name="name" width="100%" type="text" readonly="readonly" value=<%=ub.getName() %>></td></tr>
		<tr><td>Passwd</td><td><input id="Passwd" name="Passwd" width="100%" type="text" value=<%=ub.getPasswd() %>></td></tr>
		<tr><td>Email</td><td><input width="100%" type="text" value=<%=ub.getEmail() %>></td></tr>
		<tr><td>CustomLevel</td><td><input width="100%" type="text" value=<%=ub.getUserlevel() %>></td></tr>
		<tr>
			<td colspan="2"><table align="center" width="100%">
				<tr>
					<td width="50%" align="center"><input type="submit" value="Update"></td>
					<td align="center"><input type="button" value="Delete" onclick="delUser();"></td>
				</tr>
			</table></td>
		</tr>
	</table>
	</form>
	<br>
	<a href="<%=request.getContextPath() %>/Model1/ManagementUsers.jsp?pageNow=<%=pageNow %>">Return Management</a>
	</center>
</body>
</html>