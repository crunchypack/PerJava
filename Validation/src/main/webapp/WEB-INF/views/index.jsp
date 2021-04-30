<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<title>Books</title>
</head>
<body>
<div class="container">
<div class="add-form">
<form:form action="addBook" method="post" modelAttribute="book">
<fieldset>
<legend>Add Book</legend>
<div class="formField">
		<form:label path="title">Title</form:label> <br>
		<form:input path="title" type="text" id="title" /> <br>
		<form:errors path="title" cssClass="red"/>
	</div>
	<div class="formField">
		<label>Author</label> <br>
		<form:input path="author" type="text" id="author" /> <br>
		<form:errors path="author"  cssClass="red"/>
	</div>
	<div class="btn">
	<input type="submit" name="submit" value="Add book">
	</div>
</fieldset>
	
</form:form>
</div>
<div class="items">
<table border="1" >
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>     
            <th>Action</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>
                <a href="edit?id=${book.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="delete?id=${book.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</div>

</body>
</html>
