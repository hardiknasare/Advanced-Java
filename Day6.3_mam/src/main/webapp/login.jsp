<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h2 align="center" style="color: Blue;">
		Welcome to JSP ! Time :
		<%=LocalDateTime.now()%></h2>
	<h3>
		<a href="login.jsp">Login</a>
	</h3>
</body>
</html>