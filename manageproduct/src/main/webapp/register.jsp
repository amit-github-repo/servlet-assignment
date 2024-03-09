<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h2 >User Details</h2>
		<br />
		<form method="post" action="RegisterUserData">
			User Name: <input type="text" id="user_name" name="user_name" />
			<br />
			User Id: <input type="text" id="user_id" name="user_id" placeholder="Email or Mobile" />
			<br />
			Password: <input type="password" id="password" name="password" />
			<br />
			<br />
			Role Name: <input type="radio" id="student" name="role" value="student">Student</input>
					   <input type="radio" id="teacher" name="role" value="teacher">Teacher</input>
			<br />
			<input type="submit" value="CreateUser" />
		</form>
		<a href="login.jsp">Login Page</a>
</body>
</html>