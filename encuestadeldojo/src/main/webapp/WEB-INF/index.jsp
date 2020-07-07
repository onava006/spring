<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="border">
		<form action="/result" method="POST">
			<div class="block">
				<label for="name" class="column">Name: </label> 
				<label for="dojolocation" class="column">Dojo Location: </label> 
				<label for="favoritelanguage" class="column">Favorite language: </label>
			</div>
			<div class="block">
				<input type="text" name="name" id="name" style="display: block;"> 				
				<select	name="dojolocation" id="dojolocation" style="display: block;">
					<option value="Online">Online</option>
					<option value="Seattle">Seattle</option>
					<option value="Boise">Boise</option>
					<option value="Chicago">Chicago</option>
					<option value="Dallas">Dallas</option>
					<option value="San Jose">San Jose</option>
				</select> 
				<select name="favoritelanguage" id="favoritelanguage" style="display: block;">
					<option value="Java">Java</option>
					<option value="goLang">Go</option>
					<option value="C++">C++</option>
					<option value="Pascal">Pascal</option>
					<option value="Python">Python</option>
					<option value="Rust">Rust</option>
				</select>
			</div>
			<br>
		<div>
			<label for="comment"></label> <input type="text" name="comment"
				placeholder="Write something.." style="height: 100px; width: 80%" > 
			<input type="submit" name="submit" style="display: block;">
		</div>
		</form>
	</div>
</body>
</html>