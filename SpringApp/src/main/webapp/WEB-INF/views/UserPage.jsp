<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>
<%
String sessionName ="";
if(session.getAttribute("u") != null){
	sessionName = session.getAttribute("u").toString();
}%>

<div class="request_container">
	<h1>Name from Request</h1>
	<h3>${user_name }</h3>
</div>
<div>
	<h1>Name from Session</h1>
	<h3><%=session.getAttribute("u") %></h3>
</div>
</body>
</html>