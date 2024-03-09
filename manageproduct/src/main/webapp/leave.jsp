<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//alert("hello");
		$.ajax({
			url:"GetEmpName",
			type:"POST",
			dataType:"JSON",
			data:{},
			success:function(res){
				//alert(res);
				op="";
				$.each(res,function(key, v){
					op=op+'<option value="'+v.emp_id+'">'+v.emp_name+'</option>';
				})
				$("#emp_name").html(op);	
			}
		})
		
		$("#emp_name").change(function(){
			$.ajax({
				url:"GetLeave",
				type:"POST",
				dataType:"JSON",
				data:{emp_id:$("#emp_name").val()},
				success:function(res){
					//alert(res);
					op="";
					$.each(res,function(key, v){
						op=op+'<option data-id="'+v.no_of_leave+'" value="'+v.leave_id+'">'+v.leave_name+'</option>';
					})
					$("#leave_name").html(op);
				}
			})
		})
	})
	function validate(){
		assignLeave = parseInt(document.getElementById('leave_name').selectedOptions[0].getAttribute('data-id'));
		userLeave = parseInt(document.getElementById('no_of_leave').value);
		//alert(assignLeave+" "+userLeave);
		if (userLeave <= assignLeave){
			return true;
		}else{
			alert("Maximum leave you can take is "+assignLeave);
			return false;
		}	
	}
	
</script>

</head>
<body>
	<form method="post" action="PutLeave" onsubmit="return validate()">
		Employee Name : <select id="emp_name" name="emp_name"></select>
		<br />
		Leave Type : <select id="leave_name" name="leave_name"></select>
		<br />
		No. of Leave : <input type="text" id="no_of_leave" name="no_of_leave"></input>
		<br />
		
		<input type="submit" value="Apply" />
	</form>
</body>
</html>