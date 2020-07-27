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
<div style="display:inline-block;min-width:500px;min-height:200px;margin-left:40px;">
	<h2>${content.getName()}</h2>
	<h3>${content.getCreator()}</h3>
	<h3>${content.getCurrentVersion()}</h3>
	<h3><a href="/language/delete/${language.getId()}">delete</a></h3>
	<h3><a href="/language/edit/${language.getId()}">edit</a></h3>
</div>
<div style="display:inline-block; margin-left:200px"> 
	<a href="/language">Return to dashboard</a>
</div>
</body>
</html>