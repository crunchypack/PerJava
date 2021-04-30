<%@page import="com.springmvc.classes.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, td, th {
  border: 1px solid black;
}

table {
  width: 100%;
  border-collapse: collapse;
}
</style>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>

	<div>
		<table>
		<thead>
			<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>User Name</th>
			<th>Gender</th>
			<th>Email</th>
			<th>LinkedIn</th>
			<th>Phone</th>
			<th>Social Security</th>
			<th>Credit Card</th>
			<th>Date of birth</th>
			</tr>
		</thead>
		<tbody>
		<tr>
		<td>${user.firstName }</td>
		<td>${user.lastName }</td>
		<td>${user.userName }</td>
		<td>${user.gender }</td>
		<td>${user.contactInfo.email}</td>
		<td>${user.contactInfo.linkedUrl }</td>
		<td>${user.contactInfo.phoneNumber}</td>
		<td>${user.privateInfo.ssn }</td>
		<td>${user.privateInfo.ccn}</td>
		<td>${user.privateInfo.dob}</td>
		</tr>
		</tbody>
		</table>
	</div>	
</body>
</html>