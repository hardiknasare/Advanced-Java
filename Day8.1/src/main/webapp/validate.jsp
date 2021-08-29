<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Day 8.1</title>
</head>
<%--Create JB instance w/o java code : jsp:useBean --%>
<%--session.setAttribute("user",new UserBean()) --%>
<jsp:useBean id="user" class="beans.UserBean" scope="session" />
<%--Invoke ALL MATCHING setters of JB --%>
<jsp:setProperty property="*" name="user"/>
<body>
<%--Invoke B.L method of the JB w/o scriptlet , instead using EL--%>
<%-- session.getAttribute("user").authenticateUser()--%>
<%-- <h4> Navigational outcome : ${sessionScope.user.authenticateUser()}</h4> --%>
<!-- WC : RD rd = request.getRD(Session.getAttribute("user")).authenticateUser().concat("jsp"); -->
<jsp:forward page="${sessionScope.user.authenticateUser()}.jsp"/>
</body>
</html>