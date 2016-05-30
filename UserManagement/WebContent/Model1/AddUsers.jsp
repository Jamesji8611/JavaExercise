<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%">
		<tr>
			<td width="120" length="180"><img src="<%=request.getContextPath()%>/images/003.gif" width="117" length="175"></td>
			<td align="left">Welcome, <%=request.getSession().getAttribute("UserName").toString() %></td>
		</tr>
	</table>
	<hr>
	<h1>Add Users</h1>
</body>
</html>