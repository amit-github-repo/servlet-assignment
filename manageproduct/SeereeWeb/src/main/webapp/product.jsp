<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#prodname").blur(function(){
			prodname=$("#prodname").val();
			//alert(prodname);
			$.ajax({
				url:"GetProduct",
				type:"POST",
				dataType:"JSON",
				data:{prodname:prodname},
				success:function(res){
					//alert(res);
					json_text=JSON.stringify(res);
					obj=JSON.parse(json_text);
					//alert(obj.prodrate);
					$("#prodrate").val(obj.prodrate);
					$("#prodqty").val(obj.prodqty);
					
					$("#prodid").val(obj.prodid);
					$("#oldqty").val(obj.prodqty);			
				}
			})
			
		})
	})	

</script>	
<script type="text/javascript">
	function validate() {
		
		qtyError=false;
		isValidQty();
		
		function isValidQty(){
			var userQty=parseInt(document.getElementById('prodqty').value);
			var realQty=parseInt(document.getElementById('oldqty').value);
			//alert(realQty);
			if (userQty <= realQty) {
				qtyError=true;
			}else{ 
				document.getElementById('pq').innerHTML="  Your Quantity must less than "+realQty;
				qtyError=false;
			}
		}
		if (qtyError) return true;
		else return false;
		
	} 
</script>	

</head>
<body>	
	<form method="post" action="PutData" onsubmit="return validate()">
		Product Name : <input type="text" id="prodname" name="prodname" />
		<br />
		Product Rate : <input type="text" id="prodrate" name="prodrate" />
		<br />
		Product Qty : <input type="text" id="prodqty" name="prodqty" /><span id="pq"></span> 
		<br />
		<input type="hidden" id="prodid" name="prodid" />
		<input type="hidden" id="oldqty" name="oldqty" />
		<br />
		<input type="submit" value="AddCart" />
		<!-- <p id="demo" /> -->
		
	</form>
</body>
</html>