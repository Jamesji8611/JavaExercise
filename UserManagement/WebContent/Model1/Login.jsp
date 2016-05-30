<%@page import="java.net.URLDecoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String inf = request.getParameter("inf");
	if(inf != null){
		inf = URLDecoder.decode(inf);
	}else{
		inf="";
	}
%>
</head>
<body>
	<table width="100%">
		<tr>
			<td width="40%"><img src="<%=request.getContextPath()%>/images/003.gif" height="117" width="175"></td>
			<td width="50%"><h1 align="left">Login</h1></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><%=inf %></td>
		</tr>
	</table>
	<hr>
	<form action="<%=request.getContextPath()%>/logincheck" method="post">
		<table align="center">
			<tr>
				<td align="left">UserName:</td>
				<td><input type="text" name="UserName"/></td>
			</tr>
			<tr>
				<td align="left">Passwd:</td>
				<td><input type="password" name="Passwd"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="submit"/>
					<input type="reset" value="Reset"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>