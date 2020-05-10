<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/jaxrsapp/carapi/cars" method="post">
		<label>Enter Model</label><br/>
		<input type="text" name="model" ><br/>
		<label>Enter Brand</label><br/>
		<input type="text" name="brand" ><br/>
		<label>Enter Year</label><br/>
		<input type="text" name="year" ><br/>
		<label>Enter Color</label><br/>
		<input type="text" name="color" ><br/>
		<label>Enter Type</label><br/>
		<input type="text" name="type" ><br/>
		<input type="submit" value="Submit">
	</form>
</body>
</html>