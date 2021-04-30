<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<title>Message sent</title>
</head>
<body>
<%@include file='header.jsp' %>
<div class="container">
	<div class="intro">
		<h4>Thank you, ${name }</h4>
		<p> Your message has been received</p>
		
	</div>
</div>
</body>
</html>