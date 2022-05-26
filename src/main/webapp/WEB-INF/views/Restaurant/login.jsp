<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>

    <link href="<spring:url value='/css/bootstrap.css'/>" type="text/css" rel="stylesheet" />
    <script src="<spring:url value='/js/jquery-3.1.1.js'/>"></script>
    <script src="<spring:url value='/js/bootstrap.js'/>"></script>
    <script src="<spring:url value='/js/angular.js'/>"></script>

    <title>Restoms: Login</title>
</head>

<body background="<spring:url value='/images/loginbg.jpg'/>" style="background: url('http://localhost:8080/Restaurant/images/loginbg.jpg') no-repeat center fixed; background-size: cover;">
    <div class="container">
        <div class="se-pre-con"></div>
        <!-- <div class="img-responsive" style="/* background-image:url('/images/login3.jpg'); */background-repeat: no-repeat;height:700px;width:1400px;background-size: auto"> -->

        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <div class="col-xs-3">
        </div>
        <div class="col-xs-6 container">
            <br />
            <div>
                <!--login tab-->

                <div id="login" class="tab-pane fade in ">
                    <form method="post">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" name="uname" placeholder="Enter username" class="form-control"
                                required="required" />
                        </div><br />

                        <div class="input-group pure-control-group">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-lock "></span></span>
                            <input type="password" name="password" id="Password1" placeholder="Enter Password"
                                class="form-control" required="required" />
                        </div><br />
                        <h1 style="color:red;">${requestScope.msg}</h1>
                        <div class="text-center">
                            <button type="submit" class="btn btn-success pure-button pure-button-primary"
                                value="Log-in">Log-in</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>