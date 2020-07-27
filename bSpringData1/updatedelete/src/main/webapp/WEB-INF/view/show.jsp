<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="${book.getTitle()}"/>
	</h1>
	<p>
		Description:
		<c:out value="${book.getDescription()}"/>
	</p>
	<p>
		Language:
		<c:out value="${book.getLanguage()}"/>
	</p>
	<p>
		Number of pages:
		<c:out value="${book.getPages()}"/>
	</p>
	<a href="/books/${book.getId()}/edit">Edit Book</a>
	
	<form action="/api/books/${book.getId()}/delete" method="get">
		<input type="hidden"> <input type="submit" value="Delete">
	</form>

</body>
</html>


