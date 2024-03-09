<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit</title>
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
		<table border="1">
			<caption><h2>In-Place Edit Example</h2></caption>
				<tr><th>UserId</th><th>Name</th><th>Password</th><th>Role</th><th>Status</th><th>Action</th></tr>
				<tr>
					<td>james@gmail.com</td>
					<td>James</td>
					<td>James123</td>
					<td>Teacher</td>
					<td>1</td>
					<td><a class="edit" href="javascript:">Edit</a></td>
					
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
</html>