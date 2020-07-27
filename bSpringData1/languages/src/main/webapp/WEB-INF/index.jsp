<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Está conectando</h1>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Language</th>
				<th>Funciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="language">
				<tr>
					<td><a href="/language/${language.getId()}">${language.getName()}</a></td>					
					<td><c:out value="${language.getCreator()}" /></td>
					<td><c:out value="${language.getCurrentVersion()}" /></td>
					<th>
					<a href="/language/${language.getId()}/delete">delete</a>
					<a href="/language/${language.getId()}/edit">edit</a>
					</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>	

	<h3>${status}</h3>
	
	<br>

	<form:form action="/language/create" method="POST"
		modelAttribute="newlang">
		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="creator">Creator: </form:label>
			<form:errors path="creator" />
			<form:input path="creator" />
		</p>
		<p>
			<form:label path="currentVersion">Version:</form:label>
			<form:errors path="currentVersion" />
			<form:input path="currentVersion" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>

	<c:forEach items="${errors}" var="err">
		<tr>
			<td><c:out value="${err}" /></td>
		</tr>
	</c:forEach>
</body>
</html>