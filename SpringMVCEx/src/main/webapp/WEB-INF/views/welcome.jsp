<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
<%
DateTimeFormatter formate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
LocalDateTime today = LocalDateTime.now();
%>
<%@include file='header.jsp' %>
<div class="container">
	<div class="intro">
		<h1>Welcome</h1>
		<p>Todays date and time <%=formate.format(today) %></p>
	</div>
	<div class="intro">
	<p><a href="login">Login</a></p> 
	<p><a href="register">Register</a></p> 
	</div>
</div>

</body>
</html>