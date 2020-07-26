<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div>
		<span> Gold: </span> <span> <c:out value="${gold}">
			</c:out></span>
	</div>
	<div class="locations">
		<form action="/setgold" method="POST">
			<label> Farm</label> <input type="submit" value="farm" name="place">
		</form>
	</div>
	<div class="locations">
		<form action="/setgold" method="POST">
			<label> Cave</label> <input type="submit" value="cave" name="place">
		</form>
	</div>
	<div class="locations">
		<form action="/setgold" method="POST">
			<label> House</label> <input type="submit" value="house" name="place">
		</form>
	</div>
	<div class="locations">
		<form action="/setgold" method="POST">
			<label> Casino!</label> <input type="submit" value="casino"
				name="place">
		</form>
	</div>


	<div>


	 <c:forEach var="lang" items="${events}">
        <p style="display: block;">${lang}</p>
   </c:forEach>
   
	</div>
</body>
</html>