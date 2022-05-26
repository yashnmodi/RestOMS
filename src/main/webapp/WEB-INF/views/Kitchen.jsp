<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<spring:url value='/css/bootstrap.css'/>" type="text/css" rel="stylesheet" />
    <script src="<spring:url value='/js/jquery-3.1.1.js'/>"></script>
    <script src="<spring:url value='/js/bootstrap.js'/>"></script>
    <script src="<spring:url value='/js/angular.js'/>"></script>
    <title>Restoms: Kitchen</title>
</head>

<body>
    <div style="height:42px; font-family:'Adobe Devanagari'; text-align:center">
           <h1>RestOMS: Kitchen</h1>
           <br/>
           <h3>${requestScope.orderPrepared}</h3>
       </div>
    <table class="table table-responsive">
        <tr>
            <th>Table No</th>
            <th>Item Name</th>
            <th>Quantity</th>
        </tr>
        <c:forEach var="order" items="${sessionScope.OrderList}">
            <tr>
                <td>${order.tableNo}</td>
                <td>${order.item}</td>
                <td>${order.quantity}</td>
                <td><a href="<spring:url value='/Kitchen/deleteOrderFromKitchen?oid=${order.orderId}'/>">Ready</a></td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>