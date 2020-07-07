<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="border">

		<h2>Submitted info</h2>
		<div class="block">
			<p>Name:</p>
			<p>Dojo Location:</p>
			<p>Favorite Language:</p>

		</div>
		<div class="block">
			<p>
				<c:out value="${name}"></c:out>
			</p>
			<p>
				<c:out value="${location}"></c:out>
			</p>
			<p>
				<c:out value="${language}"></c:out>
			</p>
		</div>
		<div>
			<p>Comment:</p>
			<p>
				<c:out value="${comment}"></c:out>
			</p>
		</div>

		<a href="/" style="display: block;"><button>go back</button></a>
	</div>
	

</body>
</html>