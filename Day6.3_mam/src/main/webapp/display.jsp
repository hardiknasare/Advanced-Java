<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// getting content from user
	String email=request.getParameter("email");
	String password=request.getParameter("pass");
	
	//sending the same to the client
	//out.print("<h4>Email"+email+"</h4>");
	//out.print("<h4>Password"+password+"</h4>");
	
	%>
	<h4>Email :
	<% out.print(email); %>
	</h4>
	
	<h4>Password : 
	<% out.print(password);	%>
	</h4>
</body>
</html>