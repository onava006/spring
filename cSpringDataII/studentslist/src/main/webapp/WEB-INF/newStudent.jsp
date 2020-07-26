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
	<div style="margin-left: 20px;">
	<h1> New Student</h1>
	
		<form:form action="/students/create" method="POST" modelAttribute="newStudent">

			<form:label path="firstName">First Name: </form:label>
			<form:errors path="firstName"></form:errors>
			<form:input path="firstName"></form:input>
<br>
			<form:label path="lastName">Last Name: </form:label>
			<form:errors path="lastName"></form:errors>
			<form:input path="lastName"></form:input>
<br>
			<form:label path="age">Age: </form:label>
			<form:errors path="age"></form:errors>
			<form:input path="age"></form:input>
<br>
			<input type=submit value="Create">

		</form:form>
	</div>
	<h1>
		<c:out value="${status}">
		</c:out>
	</h1>



</body>
</html>
