<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<title>Contact form</title>
</head>
<body>
<%@include file='header.jsp' %>
<div class="container">
	<div class="formcontainer">
		 <form action="confirm" method="post">
		 <div class="row">
		 	<div class="col-25">
		 		<label for="name">Name</label>
		 	</div>
		 	<div class="col-75">
		 		<input type="text" id="name" name="name" placeholder="Your name.." required="required">
		 	</div>
		 </div>
		 <div class="row"><div class="col-25">
      <label for="message">Message</label>
    </div>
    <div class="col-75">
      <textarea id="message" name="message" placeholder="Write something.." style="height:200px" required="required"></textarea>
    </div>
  </div>
  <div class="row">
    <input type="submit" value="Submit">
  </div>
  </form>

	</div> 
</div>
</body>
</html>