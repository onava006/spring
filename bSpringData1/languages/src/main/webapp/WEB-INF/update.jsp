<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ page isErrorPage="true" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<h1>Edit Language</h1>
<form:form action="/language/${content.id}" method="POST" modelAttribute="content">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Name: </form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator: </form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version: </form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>