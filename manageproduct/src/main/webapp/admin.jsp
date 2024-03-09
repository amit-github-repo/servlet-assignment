<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Page</title>
	<%@ page import="java.sql.*" %>
	<%@ page import="org.json.*" %>
</head>
<body>
	<h2>Welcome Admin, <%=session.getAttribute("user_name") %></h2>
	<table border="2px solid black" width="50%">
		<tr><th>User Id</th><th>User Name</th><th>Role</th><th>Status</th><th>Action</th></tr>
		<%
		try{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college2","root","");
			Statement stmt = conn.createStatement();
			String admin_id = String.valueOf(session.getAttribute("user_id"));
			String sql = "select * from user_master where user_id != '"+admin_id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				out.print("<form method=post action=ManageUser>");
				out.print("<tr>");
				out.print("<td>" + rs.getString("user_id") + "</td>");
				out.print("<td>" + rs.getString("user_name") + "</td>");
				out.print("<td>" + rs.getString("role_name") + "</td>");
				out.print("<td>" + rs.getString("status") + "</td>");
				out.print("<td> <input type=hidden value="+rs.getString("user_id")+" name=user_id  /> <input type=submit value=Delete name=btn /> <input type=submit value=Edit name=btn /> </td>");
				out.print("</tr>");
				out.print("</form>");
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		%>
	</table>
</body>
</html>
