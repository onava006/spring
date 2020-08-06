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
	<P>
		<form:errors path="newNinja.*"></form:errors>
	</P>
	<form:form method="POST" action="/ninjas/new" modelAttribute="newNinja">
		<div>
			<form:label path="firstName">First Name: </form:label>
			<form:input path="firstName"></form:input>
		</div>
<br>
		<div>
			<form:label path="lasName">Last Name: </form:label>
			<form:input path="lasName"></form:input>
		</div>
<br>
		<div>
			<form:label path="age">Age </form:label>
			<form:input path="age"></form:input>
		</div>
<br>
		<div>
			<form:label path="dojoId">Select dojo:  </form:label>
			<form:select path="dojoId">
				<form:option value="-" label="-Please Select-" />
				<form:options items="${dojos}" itemValue="id" itemLabel="name" />
			</form:select>
		</div>
<br>
		<input type=submit value="crear ninja" />

	</form:form>


</body>
</html>