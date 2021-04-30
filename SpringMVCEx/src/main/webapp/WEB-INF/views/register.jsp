<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<div class="container">
	<div class="form">
		<h2>User registration</h2>
		<form action="process-registration" method="post" >
			<label for="firstName"> First name: </label>
			<input type="text" name="firstName" id="firstName" /> <br>
			<label for="lastName"> Last name: </label>
			<input type="text" name="lastName" id="lastName" /> <br>
			<label for="userName"> User name: </label>
			<input type="text" name="userName" id="userName" required="required"/> <br>
			
			<label>Gender: </label>
			<input type="radio" id="male" name="gender" value="male">
			<label for="male">Male</label>
			<input type="radio" id="female" name="gender" value="female">
			<label for="female">Female</label>
			<input type="radio" id="other" name="gender" value="other">
			<label for="other">Other</label> <br>
			
			<label for="contactInfo.phoneNumber">Phone number</label>
			<input type="tel" name="contactInfo.phoneNumber" id="contactInfo.phone" pattern="[0-9\-]+" /> <br> 
			
			<label for="contactInfo.email">Email</label>
			<input type="email" name="contactInfo.email" id="contactInfo.email" required="required"> <br>

			<label for="privateInfo.dob">Date of birth</label>
			
			<input type="text" id="privateInfo.dob" name="privateInfo.dob" placeholder="dd/mm/yyyy"> <br>
			
			<input id="sub" name="submit" type="submit" value="Submit form" />
    		
			
			
			
			
			
			
		</form>
	</div>
</div>

</body>
</html>