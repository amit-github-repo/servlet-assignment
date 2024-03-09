<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h3>Out example</h3>
	10*3= <c:out value="${10*3}" /> 
	<br />
	<c:forEach var="i" begin="1" end="5" step="1">
		<c:out value="${i}" />
		<br />
	</c:forEach>
</body>
</html>