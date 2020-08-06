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

	<h1>${dojo} Location Ninjas</h1>

	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		<tr>
		<tr>

			<c:forEach items="${ninjas}" var="ninja">
				<td>${ninja.firstName}</td>
				<td>${ninja.lasName}</td>
				<td>${ninja.age}</td>

			</c:forEach>
		</tr>

		</tbody>


	</table>

</body>
</html>