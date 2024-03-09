<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>
<body>
	<h2>Edit User !</h2><hr /><br />
	<form method="post" action="UpdateUserData">
		User ID : <% out.println(request.getParameter("user_id")); %>
		<br />
		User Name : <input type="text" value="<% out.println(request.getParameter("user_name")); %>" name="user_name" />
		<br />
		Password : <input type="text" value="<% out.println(request.getParameter("password")); %>" name="password" />
		<br />
		Role Name : <input type="text" value="<% out.println(request.getParameter("role_name")); %>" name="role_name" />
		<br />
		Status	  : <input type="text" value="<% out.println(request.getParameter("status")); %>" name="status" />
		<br />
		<input type="hidden" value="<% out.println(request.getParameter("user_id")); %>" name="user_id" />
		<input type="submit" value="Update" />
	</form>
	
</body>
</html>