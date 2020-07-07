<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> You have visited http://your_server <c:out value = "${conteo}"></c:out> times.</h2>

<a href="/your_server">Test another visit?</a>


<c:out value = "${teston}"></c:out> 
<form action="/your_server/counter" method="post">
<input  type="submit" name="reset" value="reiniciar?">
</form>
</body>
</html>