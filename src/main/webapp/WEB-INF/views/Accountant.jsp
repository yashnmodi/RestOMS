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
    <title>Restoms: Admin</title>
    <!-- <script>
	function validate()
	{
		var e=document.getElementById("list");
		if(e.options[e.selectedIndex].value >= 1)
		{
			document.getElementById("btn").disabled=false;
		}
	}
</script> -->

    <!-- <script>
$(document).ready(function(){
	$('#OrderMsg').fadeIn('slow',function(){
		
		$('#OrderMsg').delay(5000).fadeOut();
	});
	
});
</script> -->
</head>

<body>
    <!--heading-->
    ${requestScope.placeOrderMsg}
    <div style="height:42px; font-family:'Adobe Devanagari'; text-align:center">
        <h1>RestOMS: Admin</h1>
    </div>
    <section class=" col-sm-12">
        <ul class="nav nav-tabs nav-justified">
            <li>
                <a data-toggle="tab" href="#forminfo1">
                    <span style="font-size:18px;color:gray">Current Customers</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#forminfo2">
                    <span style="font-size:18px;color:gray">Order History</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#forminfo3">
                    <span style="font-size:18px;color:gray">Modify Menu</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#forminfo4">
                    <span style="font-size:18px;color:gray">Add table</span>
                </a>
            </li>
        </ul>

        <div class="tab-content">
            <!--TAB1 CURRENT CUSTOMER-->
            <div id="forminfo1" class="tab-pane fade in active">
                <div class="text-center"></div>
                <table class="table table-responsive">
                    <tr>
                        <th>OrderId</th>
                        <th>TableId</th>
                        <th>Item</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>is Paid</th>
                        <th>is Ready</th>
                        <th>is Placed</th>
                    </tr>
                    <c:forEach var="cust" items="${sessionScope.custlist}">
                        <tr>
                            <td>${cust.orderId}</td>
                            <td>${cust.tableNo}</td>
                            <td>${cust.item}</td>
                            <td>${cust.price}</td>
                            <td>${cust.quantity}</td>
                            <td>${cust.paid}</td>
                            <td>${cust.orderSubmit}</td>
                            <td>${cust.orderFlag}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <!--TAB2 ORDER HISTORY-->
            <div id="forminfo2" class="tab-pane fade in">

                <div class="text-center"></div>
                <table class="table table-responsive">
                    <tr>
                        <th>Order Id</th>
                        <th>TableNo</th>
                        <th>Item</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>is paid</th>
                        <th>submit by kitchen</th>
                        <th>is placed</th>
                        <th>Bill</th>
                        <th>Bill Date</th>
                    </tr>
                    <c:forEach var="order" items="${sessionScope.CustReplica}">
                        <tr>
                            <td>${order.orderId}</td>
                            <td>${order.tableNo}</td>
                            <td>${order.item}</td>
                            <td>${order.price}</td>
                            <td>${order.quantity}</td>
                            <td>${order.paid}</td>
                            <td>${order.orderSubmit}</td>
                            <td>${order.orderFlag}</td>
                            <td>${order.bill}</td>
                            <td>${order.billDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <!--TAB3 ADD MENU-->
            <div id="forminfo3" class="tab-pane fade">
                <ul class="nav nav-tabs nav-justified">

                    <li>
                        <a data-toggle="tab" href="#menuinfo1">
                            <span style="font-size:14px;color:gray">Add Menu</span>
                        </a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#menuinfo2">
                            <span style="font-size:14px;color:gray">Remove Menu</span>
                        </a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div id="menuinfo1" class="tab-pane fade in active">
                        <div class="container">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-6">
                                <form action="<spring:url value='/Accountant/AddMenu'/>">

                                    <div class="form-group">
                                        <label for="email">Menu Name:</label>
                                        <input type="text" class="form-control" id="menuName"
                                            placeholder="Enter Menu Name" name="menuName">
                                    </div>
                                    <div class="form-group">
                                        <label for="pwd">Price:</label>
                                        <input type="number" class="form-control" id="price" placeholder="Enter price"
                                            name="price">
                                    </div>
                                    <div class="form-group">
                                        <label for="pwd">Enter Category:</label>
                                        <input type="text" class="form-control" id="category"
                                            placeholder="Enter Category" name="category">
                                    </div>
                                    <div class="form-group">
                                        <label for="pwd">Enter Specification:</label>
                                        <input type="text" class="form-control" id="specification"
                                            placeholder="Enter specification" name="specification">
                                    </div>

                                    <button type="submit" class="btn btn-default">Add Menu</button>
                                </form>
                            </div>
                            <div class="col-sm-3"></div>
                        </div>
                    </div>
                    <div id="menuinfo2" class="tab-pane fade in">
                        <div class="container">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-6">
                                Under Development
                                <!-- <form action="<spring:url value='/Accountant/AddMenu'/>">

                                    <div class="form-group">
                                        <label for="email">Menu Name:</label>
                                        <input type="text" class="form-control" id="menuName"
                                            placeholder="Enter Menu Name" name="menuName">
                                    </div>
                                    <div class="form-group">
                                        <label for="pwd">Price:</label>
                                        <input type="number" class="form-control" id="price" placeholder="Enter price"
                                            name="price">
                                    </div>
                                    <div class="form-group">
                                        <label for="pwd">Enter Category:</label>
                                        <input type="text" class="form-control" id="category"
                                            placeholder="Enter Category" name="category">
                                    </div>
                                    <div class="form-group">
                                        <label for="pwd">Enter Specification:</label>
                                        <input type="text" class="form-control" id="specification"
                                            placeholder="Enter specification" name="specification">
                                    </div>

                                    <button type="submit" class="btn btn-default">Add Menu</button>
                                </form> -->
                            </div>
                            <div class="col-sm-3"></div>
                        </div>
                    </div>
                </div>
            </div>

            <!--Tab4 ADD TABLE-->
            <div id="forminfo4" class="tab-pane fade">
                <div class="container">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <form action="<spring:url value='/Accountant/AddTable'/>">

                            <div class="form-group">
                                <label for="email">Table:</label>
                                <input type="text" class="form-control" id="tableName" placeholder="Eg Table1"
                                    name="tableName" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Role:</label>
                                <input type="text" class="form-control" id="tableRoleName" name="role" required
                                    value="Table">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="pwd" placeholder="Enter password"
                                    name="pwd" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">confirm password:</label>
                                <input type="password" class="form-control" id="cpwd" placeholder="ReEnter Password"
                                    name="cpwd">
                            </div>
                            <button type="submit" class="btn btn-default">Add Table</button>
                        </form>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
    </section>

</body>

</html>