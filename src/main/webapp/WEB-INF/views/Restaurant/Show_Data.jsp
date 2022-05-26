<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>

<head>
    <link href="<spring:url value='/css/bootstrap.css'/>" type="text/css" rel="stylesheet" />

    <script src="<spring:url value='/js/jquery-3.1.1.js'/>"></script>
    <script src="<spring:url value='/js/bootstrap.js'/>"></script>
    <script src="<spring:url value='/js/angular.js'/>"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show Data</title>
</head>

<body>
    <div class="navbar navbar-fixed-top navbar-default" style="min-height: 60px">
        <div class="navbar-header">
            <a href="#" class="navbar-brand"><img src="images/brand.png" style="height:40px" /></a>
        </div>
    </div><br /><br />
    <!--color image-->
    <div>
        <img src="images/color.jpg" style="height:30px;width:1380px" class="img-responsive" />
    </div>
    <br />
    <!--heading-->
    <div style="height:50px;">
        <h1 style="font-family:'Adobe Devanagari';text-align:center">Build Your Profile!</h1>
    </div>
    <section class="container">
        <ul class="nav nav-tabs nav-justified">

            <li>
                <a data-toggle="tab" href="#forminfo1">
                    <span class="glyphicon" style="font-size:50px;color:gray">&#xe089;</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#forminfo2">
                    <span class="glyphicon" style="font-size:50px;color:gray">&#xe089;</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#forminfo3">
                    <span class="glyphicon" style="font-size:50px;color:gray">&#xe089;</span>
                </a>
            </li>
        </ul>

        <div class="tab-content">
            <!--TAB1-->
            <div id="forminfo1" class="tab-pane fade in active">
                <div class="text-center">
                    <h1 style="color: #1b6d85">BreakFast</h1>
                </div>
                <c:forEach var="roti" items="${sessionScope.rotiImages}">
                    <ul>
                        <li>${roti.item}</li>
                        <li>${roti.price}</li>
                        <li><img alt="No Image found" width="50px" height="50px"
                                src="<spring:url value='/uploadimages/${roti.imgPath}'/>"></li>
                    </ul>
                </c:forEach>
            </div>

            <!--TAB2-->

            <div id="forminfo2" class="tab-pane fade">
                <div class="text-center">
                    <h1 style="color: #1b6d85">Main course</h1>
                </div>
            </div>
            <!--Tab3-->
            <div id="forminfo3" class="tab-pane fade">
                <div class="text-center">
                    <h1 style="color: #1b6d85">Dessert</h1>
                </div>
            </div>

        </div>

</body>

</html>