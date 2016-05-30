<%@page import="java.net.URLDecoder"%>
<%@page import="com.userManagement.Model.UsersBeanProcess"%>
<%@page import="com.userManagement.Model.UsersBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	UsersBean ub = (UsersBean)request.getAttribute("UsersBean");
	int pageNow = Integer.parseInt(request.getParameter("pageNow"));
	String inf = (request.getParameter("inf")!=null)?(request.getParameter("inf").toString()):"";
	inf = URLDecoder.decode(inf, "utf-8");
%>
<script type="text/javascript">
	function update(){
		var id = document.getElementsByName("ID");
		alert(id);
		
	}
	function delUser(){
		if(window.confirm('确认删除?')){
			var id = document.getElementsByName("ID")[0].value;
			document.DelUserform.id.value = id;
			document.DelUserform.submit();
		}
	}
	
	function retUsers(){
		document.ReturnUsersform.submit();
	}
</script>
</head>
<body>
	<table width="100%">
		<tr>
			<td width="120"><img src="<%=request.getContextPath()%>/images/003.gif" width="117"></td>
			<td align="left">Welcome, <%=request.getSession().getAttribute("UserName").toString() %></td>
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
					<h1>Update Users</h1>
					<h2><font color="red"><%=inf %></font></h2>
					<form action="<%=request.getContextPath()%>/MVC/UsersData" name="formuser" method="post">
					<table border="1" width="30%">
						<tr><td>UserID</td><td><input style="background-color:#E4F4FC;" id="ID" name="ID" width="100%" type="text" readonly="readonly" value=<%=ub.getId() %>></td></tr>
						<tr><td>UserName</td><td><input style="background-color:#E4F4FC;" id="name" name="name" width="100%" type="text" readonly="readonly" value=<%=ub.getName() %>></td></tr>
						<tr><td>Passwd</td><td><input id="Passwd" name="Passwd" width="100%" type="text" value=<%=ub.getPasswd() %>></td></tr>
						<tr><td>Email</td><td><input width="100%" type="text" name="Email" value=<%=ub.getEmail() %>></td></tr>
						<tr><td>CustomLevel</td>
							<td>
								<input width="100%" type="text" name="customLevel" value=<%=ub.getUserlevel() %>>
								<input type="hidden" name="OpFlag" value="upuser">
							</td>
						</tr>
						<tr>
							<td colspan="2"><table align="center" width="100%">
								<tr width="100%">
									<td width="30%" align="center"><input type="submit" value="Update"></td>
									<td width="30%" align="center"><input type="button" value="Delete" onclick="delUser();"></td>
									<td width="30%" align="center"><input type="button" value="Return" onclick="retUsers();"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					</form>
					<br>
				</center>
			</td>
		</tr>
	</table>
</body>
<form action="<%=request.getContextPath() %>/MVC/UsersData" name="ReturnUsersform" method="post">
	<input type="hidden" name="pageNow" value="<%=pageNow%>"/>
	<input type="hidden" name="OpFlag" value="allusers"/>
</form>
<form action="<%=request.getContextPath() %>/MVC/UsersData" name="DelUserform" method="post">
	<input type="hidden" name="pageNow" value="<%=pageNow%>"/>
	<input type="hidden" name="id" value=""/>
	<input type="hidden" name="OpFlag" value="deluser"/>
</form>
</html>