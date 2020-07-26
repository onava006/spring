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
		<br>
		<h1>${dormRequested.name} Dormitory</h1>

		<form:form action="/dorms/${id}/add" method="POST" modelAttribute="newStudent">
			<form:label path="student_id">Students: </form:label>
			<form:select path="student_id">
				<form:options items="${students}" itemValue="id"
					itemLabel="firstName"></form:options>
			</form:select>
			<br>
			<input type="submit" value="Add" />
		</form:form>
		<p>${status}</p>
		
		<table>
		<tr>
			<th>Name</th>
			<th>Action</th>
			
		</tr>
		<c:forEach items="${studentsList}" var="student">
			<tr>
				<td>${student.firstName} ${student.lastName}</td>				
				<td><a href="/dorms/${id}/remove?student=${student.id}">DELETE</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>