<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User Invoice</title>
	<link href="<spring:url value='/css/bootstrap.css'/>" type="text/css" rel="stylesheet" />

	<script src="<spring:url value='/js/jquery-3.1.1.js'/>"></script>
	<script src="<spring:url value='/js/bootstrap.js'/>"></script>
	<script src="<spring:url value='/js/angular.js'/>"></script>
</head>

<body>
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
		<h1 align="center">Thank You!!!</h1>
		<table class="table table-responsive" align="center">
			<th>Item</th>
			<th>Price</th>
			<c:forEach var="custlist" items="${requestScope.Cust}">
				<tr>
					<td>${custlist.item}</td>
					<td>${custlist.price}</td>
				</tr>


			</c:forEach>
		</table>
		<h2 align="center">Total Bill :${requestScope.bill}</h2>
	</div>

	<div class="col-sm-4"></div>


</body>

</html>