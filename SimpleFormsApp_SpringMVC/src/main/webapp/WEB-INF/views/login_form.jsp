<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="container">
		<form action="login" method="post">
			<h3>Login form</h3>
			<label>User name</label>
			<input type="text" name="email" id="email"> <br>
			
			<label>Password</label>
			<input type="password" name="password" id="password"> <br>
			
			<input type="submit" value="Login">
			
			<label>${error}</label>
		</form>
	</div>
</body>
</html>