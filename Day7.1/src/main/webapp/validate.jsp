<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validate</title>
</head>
	<%!
	// jsp delaration block (outside body)
	HashMap<String,User > users;
	public void jspInit()
	{
		System.out.println("In jSP init");
		// create empty map
		users = new HashMap< >();
		users.put("Rama", new User("Rama","1234",25));
		users.put("Raj", new User("Raj","3234",28));
		//populating the same
	}
	//jspDestroy can be overridden from the same jsp decl block or can create another one
	%>
<body>


<%
// read name n pwd
String name = request.getParameter("name");
String pwd = request.getParameter("pass");

// validation

User validatedUser = users.get(name);

if(validatedUser != null){
	if(validateUser.getPasssword().equals(pwd))	
{
	
} else{
	%>
	<h4>
		User Name Does Not Exist ,Do you want to <a href="register.jsp">Register</a>
	</h4>
<%
}
%>
</body>
<%!
public void jspDestroy()
{
	System.out.println("In jSP Destroy");
}
%>

</html>