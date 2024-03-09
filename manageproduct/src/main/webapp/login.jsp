<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form method="post" action="ValidUser">
		User ID: <input type="text" id="user_id" name="user_id" />
		<br />
		Password: <input type="password" id="password" name="password" />
		<br />
		<input type="submit" value="Login" />
		<br />
		<a href="register.jsp">New User</a>
	</form>
</body>
</html>