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
	<h1>Contact Info</h1>

	<form:form action="${dormRequested.id}/add" method="POST" modelAttribute="newStudent">
		<form:select path="student_id">
			<form:options items="${students}" itemValue="id" itemLabel="firstName"></form:options>

		</form:select>

		<form:label path="address">Address: </form:label>
		<form:errors path="address"></form:errors>
		<form:input path="address"></form:input>

		<form:label path="city">City: </form:label>
		<form:errors path="city"></form:errors>
		<form:input path="city"></form:input>

		<form:label path="state">State: </form:label>
		<form:errors path="state"></form:errors>
		<form:input path="state"></form:input>

		<input type="submit" value="Submit" />

	</form:form>
	<h2>${status}</h2>

</body>
</html>