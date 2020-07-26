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
<script src="js/alert.js"></script>
</head>
<body onload="dateAlert()">
<script type="text/javascript" src="js/alert.js"></script>
<div>
<h1 class="dateh1 margin"><c:out value="${today}"></c:out></h1>
</div>
</body>
</html>
