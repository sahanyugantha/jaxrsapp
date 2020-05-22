<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="http://localhost:8080/jaxrsapp/carapi/users/login" method="post">
		<label>Enter email</label><br/>
		<input type="email" name="uemail" ><br/>
		<label>Enter password</label><br/>
		<input type="password" name="password" ><br/>
		<input type="submit" value="Submit">
	</form>
</body>
</html>