<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="display: block;">
		<p>actividad 1</p>
		<c:forEach items="${queryone}" var="country">
			<div style="display: inline-block;">
				<ul>
					<li>${country[0]}</li>
					<li>${country[1]}</li>
					<li>${country[2]}</li>
				</ul>
			</div>
		</c:forEach>

	</div>
	<div style="display: block;">
		<p>actividad 2</p>

		<c:forEach items="${querytwo}" var="country">
			<div style="display: inline-block;">
				<ul>
					<li>${country[0]}</li>
					<li>${country[1]}</li>
				</ul>
			</div>
		</c:forEach>
	</div>
	<div style="display: block;">
		<p>actividad 3</p>
		<c:forEach items="${querythree}" var="country">
			<div style="display: inline-block;">
				<ul>
					<li>${country[0]}</li>
					<li>${country[1]}</li>
				</ul>
			</div>
		</c:forEach>
	</div>
	<div style="display: block;">
		<p>actividad 4</p>
		<c:forEach items="${queryfour}" var="country">
			<div style="display: inline-block;">
				<ul>
					<li>${country[0]}</li>
					<li>${country[1]}</li>
				</ul>
			</div>
		</c:forEach>
	</div>
	<div style="display: block;">
		<p>actividad 5</p>
		<c:forEach items="${queryfive}" var="country">
			<div style="display: inline-block;">
				<ul>
					<li>${country}</li>
				</ul>
			</div>
		</c:forEach>
	</div>
	<div style="display: block;">
		<p>actividad 6</p>
		<c:forEach items="${querysix}" var="country">
			<div style="display: inline-block;">
				<ul>
					<li>${country}</li>
				</ul>
			</div>
		</c:forEach>
	</div>
	<div style="display: block;">
		<p>actividad 7</p>
		<c:forEach items="${queryseven}" var="country">
			<div style="display: inline-block;">
				<ul>
					<li>${country[0]}</li>
					<li>${country[1]}</li>
					<li>${country[2]}</li>
					<li>${country[3]}</li>
				</ul>
			</div>
		</c:forEach>
	</div>
	<div style="display: block;">
		<p>actividad 8</p>
		<c:forEach items="${queryocho}" var="country">
			<div style="display: inline-block;">
				<ul>
					<li>${country[0]}</li>
					<li>${country[1]}</li>
				</ul>
			</div>
		</c:forEach>
	</div>

</body>
</html>