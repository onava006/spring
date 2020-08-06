<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Dojo</h1>
<br>
	<form:errors path="newDojo.*"></form:errors>
	<form:form action="/dojos/new" method="post" modelAttribute="newDojo">
		<div class="form">
			<form:label path="name"></form:label>
			<form:input path="name"/>
		</div>
		<input type="submit" value="create Dojo">
	</form:form>
<h3> ${status}</h3>
</body>
</html>