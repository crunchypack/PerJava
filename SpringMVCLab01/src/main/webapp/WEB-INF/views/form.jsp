<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User form </title>
</head>
<body>
<div class="container">
	<div class="form">
		<h2>User form</h2>
		<form:form action="process-form" method="post" modelAttribute="user">
			<label for="firstName"> First name: </label>
			<input type="text" name="firstName" id="firstName" /> <br>
			<label for="lastName"> Last name: </label>
			<input type="text" name="lastName" id="lastName" /> <br>
			<label for="userName"> User name: </label>
			<form:input type="text" id="userName" path="userName" required="required"/> 
			<form:errors path="userName" />
			<br>
			<label for="password"> Password </label>
			<form:input type="password" name="password" id="password"  path="password"/>
			<form:errors path="password" /> <br>
			
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
			<form:input type="text" path="contactInfo.email"  required="required"/> 
			<form:errors path="contactInfo.email"/>
			<br>
			
			<label for="contactInfo.linkedUrl">LinkedIn URL</label>
			<input type="text" name="contactInfo.linkedUrl" id="contactInfo.linkedUrl"/> <br>
			
			
			 <label for="privateInfo.ssn">SSN: </label>
    		<input type="number" id="privateInfo.ssn" name="privateInfo.ssn"  > <br>
    		
    		<label for="privateInfo.ccn">Credit Card Number:</label>
    		<!-- inputmode sets the keyboard type (in this case, numeric)  autocomplete tells browser what should be autocompleted (in this case, a credit card number)-->
			<input id="privateInfo.ccn" type="number"  name="privateInfo.ccn" inputmode="numeric" pattern="[0-9\s]{13,19}" autocomplete="cc-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx"> <br>
			
			<label for="privateInfo.dob">Date of birth</label>
			
			<form:input type="text" id="privateInfo.dob" path="privateInfo.dob"  name="privateInfo.dob" placeholder="dd/mm/yyyy" /> 
			<form:errors path="privateInfo.dob"/>
			<br>
			
			<input id="sub" name="submit" type="submit" value="Submit form" />
    		
			
			
			
			
			
			
		</form:form>
	</div>
</div>

</body>
</html>