# servlet-assignment
<h2> This is the data flow structure of all file and services that i created.</h2>
<br /><br />		
Question 1
		CalcServlet.java

<br />	
Question 2
		index.jsp ------> RegisterServlet.java

<br />	
Assignment  1
		product.jsp		<---+
			|				|
			+-------> GetProduct.java
			|
			+-------> PutData.java


<br />	
Assignment  2
				+--<--- GetEmpName.java
				|
		leave.jsp 
			|   |	
			|	+--<--- GetLeave.java
			|
			+-----> PutLeave.java


<br />	
Assignment  3
	login.jsp 	 <------+
		|				|
		+-------> register.jsp ----> RegisterUserData.java
		|
		|										+----<---delete-----+
		|										|					|
		+-------> ValidUser.java ---+------> admin.jsp ------> ManageUser.java
									|			|					|
									|			|					+----edit------> edit.jsp ------> UpdateUserData.java
									|			|																|
									|			+----------------------------<----------------------------------+
									|
									+------> student.jsp
									|
									+------> teacher.jsp
									
<br />	
Task 4 :- Inline edit	(https://hoven.in/aspnet-core/js-inline-inplace-edit.html)
			inlineEdit.jsp
