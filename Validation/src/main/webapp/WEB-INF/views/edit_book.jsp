<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<title>Edit book</title>
</head>
<body>
<div class="container">
	<div align="center">
        <h2>Edit Customer</h2>
        <form:form action="addBook" method="post" modelAttribute="book">
            <table>
                <tr>
                    <td>ID: </td>
                    <td>${customer.id}
                        <form:hidden path="id"/>
                    </td>
                </tr>        
                <tr>
                    <td>Title: </td>
                    <td><form:input path="title" /></td>
                </tr>
                <tr>
                    <td>Author: </td>
                    <td><form:input path="author" /></td>
                </tr>  
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>                    
            </table>
        </form:form>
	</div>
</div>
</body>
</html>