<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Page</title>
	<%@ page import="java.sql.*" %>
	<%@ page import="org.json.*" %>
		<style type="text/css">
			table {
			    width: 75%;
			    margin: 4px auto;
			    table-layout: auto;
		  	}
			td {
		    	padding: 2px;
		 	}
		</style>
</head>
<body>
	<h2>Welcome Admin, <%=session.getAttribute("user_name") %></h2>
	
	<table  border="1px solid black">
		<tr><th>User Id</th><th>User Name</th><th>Password</th><th>Role</th><th>Status</th><th>Action</th></tr>
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
				out.print("<td>" + rs.getString("password") + "</td>");
				out.print("<td>" + rs.getString("role_name") + "</td>");
				out.print("<td>" + rs.getString("status") + "</td>");
				out.print("<td> <input type=hidden value="+rs.getString("user_id")+" name=user_id  /> <input type=submit value=Delete name=btn /> <a class=\"edit\" href=\"javascript:\">Edit</a> </td>");
				out.print("</tr>");
				out.print("</form>");
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		%>
				<tr hidden="hidden" id="boxes">
					<td><input id="user_id" name="user_id" style ="border: none; outline:none" readonly="readonly" /></td>
					<td><input id="user_name" name="user_name" /></td>
					<td><input id="password" name="password" /></td>
					<td><input id="role_name" name="role_name" /></td>
					<td><input id="stats" name="stats" /></td>
					<td><input type="button" id="aUpdate" value="Update" onclick="javascript:" />	|	<input type="button" id="aCancel" value="Cancel" onclick="javascript:" /></td>
				</tr>
	</table>
	<script type="text/javascript">
			(function () {
				let currentTR;
				document.querySelectorAll("a.edit").forEach(a => {
					a.addEventListener("click", function () {
						if (currentTR) {
				        	aCancel.click();
				        }
						currentTR = a.closest("tr");
						currentTR.insertAdjacentElement('beforebegin', boxes);
						currentTR.hidden = true;
						user_id.value = currentTR.cells[0].innerText.trim();
				        user_name.value = currentTR.cells[1].innerText.trim();
				        password.value = currentTR.cells[2].innerText.trim();
				        role_name.value = currentTR.cells[3].innerText.trim();
				        stats.value = currentTR.cells[4].innerText.trim();
						boxes.hidden = false;
					});
				});
				aCancel.addEventListener("click", function () {
			    	boxes.hidden = true;
			    	currentTR.hidden = false;
			    });
			})();
	</script>
</body>
</html>







<%--

<input type=\"button\" class=\"edit\" value=\"Edit\" onclick=\"javascript:\" /> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit</title>
		
	</head>
	<body>
		<table border="1">
			<caption><h2>In-Place Edit Example</h2></caption>
				<tr><th>UserId</th><th>Name</th><th>Password</th><th>Role</th><th>Status</th><th>Action</th></tr>
				<tr>
					<td>james@gmail.com</td>
					<td>James</td>
					<td>James123</td>
					<td>Teacher</td>
					<td>1</td>
					<td></td>
					
				</tr>
				<tr>
					<td>marry@gmail.com</td>
					<td>Marry</td>
					<td>Marry123</td>
					<td>Student</td>
					<td>1</td>
					<td><a class="edit" href="javascript:">Edit</a></td>
					
				</tr>
				
				<!-- the tr that contains edit mode controls -->
				<tr hidden="hidden" id="boxes">
					<td><input id="userid" name="userid" style ="border: none; outline:none" readonly="readonly" /></td>
					<td><input id="username" name="username" /></td>
					<td><input id="password" name="password" /></td>
					<td><input id="role" name="role" /></td>
					<td><input id="stats" name="stats" /></td>
					<td><a href="javascript:" id="aUpdate">Update</a>	|	<a href="javascript:" id="aCancel">Cancel</a></td>
				</tr>
		</table>
		<script type="text/javascript">
			(function () {
				// currently being edited tr row 
		    	let currentTR;
		    	// query all  "edit" anchors 
			    document.querySelectorAll("a.edit").forEach(a => {
			    	  // attach click event handler to each "edit" 
				      a.addEventListener("click", function () {
				    	    // cancel any pending edits 
					        if (currentTR) {
					        	aCancel.click();
					        }
					    	// find the parent tr of the clicked edit 
					        currentTR = a.closest("tr");
					    	// insert the boxes along it 
					        currentTR.insertAdjacentElement('beforebegin', boxes);
					    	// hide the tr 
					        currentTR.hidden = true;
					    	// fill data into the inputs 
					        userid.value = currentTR.cells[0].innerText.trim();
					        username.value = currentTR.cells[1].innerText.trim();
					        password.value = currentTR.cells[2].innerText.trim();
					        role.value = currentTR.cells[3].innerText.trim();
					        stats.value = currentTR.cells[4].innerText.trim();
					    	// show the boxes 
					        boxes.hidden = false;
				      });
			    });
		    	
			    aCancel.addEventListener("click", function () {
			    	boxes.hidden = true;
			    	currentTR.hidden = false;
			    });
			    
			    aUpdate.addEventListener("click", function () {
			    	// hide the input controls 
				    boxes.hidden = true;
				 	// set the values of td 
				    currentTR.cells[0].innerText = userid.value;
				    currentTR.cells[1].innerText = username.value;
				    currentTR.cells[2].innerText = password.value;
				    currentTR.cells[3].innerText = role.value;
				    currentTR.cells[4].innerText = stats.value;
				 	// show the td 
				    currentTR.hidden = false;
				});
			    
			})();
		</script>
	</body>
</html>--%>