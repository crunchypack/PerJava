<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<div class="container">
		<div class="form">
			<form action="process-login" method="post">
				<label for="userName">User name: </label>
				<input type="text" name="userName" id="userName" required="required">
				<label for="password">Password</label>
				<input type="password" name="password" id="password" required="required">
				<input type="submit" value="Login">
			</form>
		</div>
	</div>
</body>
</html>