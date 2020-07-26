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

	<div style="display: block;">
		<p>actividad 1</p>
		<p>Big boss employers</p>
		<c:forEach items="${emp}" var="worker">
			<div style="display: inline-block;">
				<ul>
					<li>${worker[0]}</li>

					<li>${worker[1]}</li>
				</ul>
			</div>
		</c:forEach>
		`

		<p>Felipe Avello employers</p>
		<c:forEach items="${emp2}" var="worker">
			<div style="display: inline-block;">
				<ul>
					<li>${worker[0]}</li>

					<li>${worker[1]}</li>
				</ul>
			</div>
		</c:forEach>
		
		<p>
			El manager de ${employeeWorkers[0]}
		</p>
		
			

	</div>

</body>
</html>