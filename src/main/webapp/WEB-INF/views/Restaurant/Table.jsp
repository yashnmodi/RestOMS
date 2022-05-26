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
    <title>Restoms: Menu</title>
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
    <div class="container">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="<spring:url value='/images/cara1.jpg'/>" alt="Image 1" style="width:1200px;height:170px;">
                </div>

                <div class="item">
                    <img src="<spring:url value='/images/cara2.jpg'/>" alt="Image 2" style="width:1200px;height:170px;">
                </div>

                <div class="item">
                    <img src="<spring:url value='/images/cara3.jpg'/>" alt="Image 3" style="width:1200px;height:170px;">
                </div>
            </div>
            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <h4>${requestScope.notselectedmenu}</h4>
    <h4>${requestScope.placeOrderMsg}</h4>
    <div style="height:50px;">
        <h1 style="font-family:'Adobe Devanagari';text-align:center">Select your Food!</h1>
    </div>

    <section class="container col-sm-9 ">
        <ul class="nav nav-tabs nav-justified">

            <li>
                <a data-toggle="tab" href="#forminfo1">
                    <span style="font-size:10px;color:gray">BREAKFAST</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#forminfo2">
                    <span style="font-size:10px;color:gray">STARTER</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#forminfo3">
                    <span style="font-size:10px;color:gray">MAIN COURSE</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#forminfo4">
                    <span style="font-size:10px;color:gray">DESSERT</span>
                </a>
            </li>
            <li>
                <a data-toggle="tab" href="#forminfo5">
                    <span style="font-size:10px;color:gray">MUSIC</span>
                </a>
            </li>
        </ul>

        <div class="tab-content">
            <!--TAB1 BREAKFAST-->
            <div id="forminfo1" class="tab-pane fade in active">
                <table>
                    <tr>
                        <c:forEach var="breakfast" items="${sessionScope.breakfastImages}">
                            <form action="<spring:url value='/Restaurant/ProcessOrder'/>">
                                <td>
                                    <table>
                                        <tr>
                                            <td>
                                                <img hspace="20" alt="No Image found" width="150px" height="150px"
                                                    class="img-responsive"
                                                    src="<spring:url value='/uploadimages/${breakfast.imgPath}'/>">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${breakfast.menuId}" name="mid"></td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${sessionScope.table.uname}" name="tid">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>${breakfast.item}</td>
                                        </tr>
                                        <tr>
                                            <td>${breakfast.price}</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <select name="qty">
                                                    <option value="">options</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" class="btn btn-warning" value="add to cart"></td>
                                        </tr>
                                    </table>
                                </td>
                            </form>
                        </c:forEach>
                    </tr>
                </table>

            </div>
            <!--TAB2 STARTER-->
            <div id="forminfo2" class="tab-pane fade in">

                <table>
                    <tr>
                        <c:forEach var="soup" items="${sessionScope.soupImages}">
                            <form action="<spring:url value='/Restaurant/ProcessOrder'/>">
                                <td>
                                    <table>

                                        <tr>
                                            <td>
                                                <img alt="No Image found" hspace="20" width="150px" height="150px"
                                                    class="img-responsive"
                                                    src="<spring:url value='/uploadimages/${soup.imgPath}'/>">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${soup.menuId}" name="mid"></td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${sessionScope.table.uname}" name="tid">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>${soup.item}</td>
                                        </tr>
                                        <tr>
                                            <td>${soup.price}</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <select name="qty">
                                                    <option value="">options</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>

                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" class="btn btn-warning" value="add to cart"></td>
                                        </tr>


                                    </table>
                                </td>
                            </form>
                        </c:forEach>
                    </tr>
                    <tr>
                        <c:forEach var="starter" items="${sessionScope.starterImages}">
                            <form action="<spring:url value='/Restaurant/ProcessOrder'/>">
                                <td>
                                    <table>
                                        <tr>
                                            <td>
                                                <img class="img-responsive" alt="No Image found" hspace="20"
                                                    width="150px" height="150px"
                                                    src="<spring:url value='/uploadimages/${starter.imgPath}'/>">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${starter.menuId}" name="mid"></td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${sessionScope.table.uname}" name="tid">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>${starter.item}</td>
                                        </tr>
                                        <tr>
                                            <td>${starter.price}</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <select name="qty">
                                                    <option value="">options</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" class="btn btn-warning" value="add to cart"></td>
                                        </tr>
                                    </table>
                                </td>
                            </form>
                        </c:forEach>
                    </tr>
                </table>
            </div>
            <!--TAB3 MAINCOURSE-->

            <div id="forminfo3" class="tab-pane fade">

                <table>

                    <tr>
                        <c:forEach var="roti" items="${sessionScope.rotiImages}">
                            <form action="<spring:url value='/Restaurant/ProcessOrder'/>">
                                <td>
                                    <table cellspacing="5">
                                        <tr>
                                            <td>
                                                <img alt="No Image found" width="150px" height="150px"
                                                    src="<spring:url value='/uploadimages/${roti.imgPath}'/>">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${roti.menuId}" name="mid"></td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${sessionScope.table.uname}" name="tid">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>${roti.item}</td>
                                        </tr>
                                        <tr>
                                            <td>${roti.price}</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <select name="qty">
                                                    <option value="">options</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>

                                                </select>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" class="btn btn-warning" value="add to cart"></td>
                                        </tr>

                                    </table>
                                </td>
                            </form>
                        </c:forEach>
                    </tr>


                    <tr>
                        <c:forEach var="paratha" items="${sessionScope.parathaImages}">
                            <form action="<spring:url value='/Restaurant/ProcessOrder'/>">
                                <td>
                                    <table cellspacing="5">
                                        <tr>
                                            <td>
                                                <img alt="No Image found" width="150px" height="150px"
                                                    class="img-responsive"
                                                    src="<spring:url value='/uploadimages/${paratha.imgPath}'/>">
                                            </td>
                                        </tr>

                                        <tr>
                                            <td><input type="hidden" value="${paratha.menuId}" name="mid"></td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${sessionScope.table.uname}" name="tid">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>${paratha.item}</td>
                                        </tr>
                                        <tr>
                                            <td>${paratha.price}</td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <select name="qty">
                                                    <option value="">options</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>

                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" class="btn btn-warning" value="add to cart"></td>
                                        </tr>


                                    </table>
                                </td>
                            </form>
                        </c:forEach>
                    </tr>

                    <tr>
                        <c:forEach var="sabji" items="${sessionScope.sabjiImages}">
                            <form action="<spring:url value='/Restaurant/ProcessOrder'/>">
                                <td>
                                    <table cellspacing="5">
                                        <tr>
                                            <td>
                                                <img class="img-responsive" alt="No Image found" hspace="20"
                                                    width="150px" height="150px"
                                                    src="<spring:url value='/uploadimages/${sabji.imgPath}'/>">

                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${sabji.menuId}" name="mid"></td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${sessionScope.table.uname}" name="tid">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>${sabji.item}</td>
                                        </tr>
                                        <tr>
                                            <td>${sabji.price}</td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <select name="qty">
                                                    <option value="">options</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>

                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" class="btn btn-warning" value="add to cart"></td>
                                        </tr>


                                    </table>
                                </td>
                            </form>
                        </c:forEach>
                    </tr>

                    <tr>
                        <c:forEach var="rice" items="${sessionScope.riceImages}">
                            <form action="<spring:url value='/Restaurant/ProcessOrder'/>">
                                <td>
                                    <table cellspacing="5">
                                        <tr>
                                            <td>
                                                <img class="img-responsive" alt="No Image found" width="150px"
                                                    height="150px"
                                                    src="<spring:url value='/uploadimages/${rice.imgPath}'/>">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${rice.menuId}" name="mid"></td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${sessionScope.table.uname}" name="tid">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>${rice.item}</td>
                                        </tr>
                                        <tr>
                                            <td>${rice.price}</td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <select name="qty">
                                                    <option value="">options</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>

                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" class="btn btn-warning" value="add to cart"></td>
                                        </tr>


                                    </table>
                                </td>
                            </form>
                        </c:forEach>
                    </tr>



                </table>
            </div>
            <!--Tab4 DESSERT-->
            <div id="forminfo4" class="tab-pane fade">

                <table cellspacing="5">
                    <tr>
                        <c:forEach var="Dessert" items="${sessionScope.dessertImages}">
                            <form action="<spring:url value='/Restaurant/ProcessOrder'/>">
                                <td>

                                    <table>

                                        <tr>
                                            <td>

                                                <img alt="No Image found" hspace="20" width="150px" height="150px"
                                                    class="img-responsive"
                                                    src="<spring:url value='/uploadimages/${Dessert.imgPath}'/>">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${Dessert.menuId}" name="mid"></td>
                                        </tr>
                                        <tr>
                                            <td><input type="hidden" value="${sessionScope.table.uname}" name="tid">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>${Dessert.item}</td>
                                        </tr>
                                        <tr>
                                            <td>${Dessert.price}</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <select name="qty" onchange="validate()" id="list">
                                                    <option value="">options</option>
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>

                                                </select>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" id="btn" class="btn btn-warning"
                                                    value="add to cart"></td>
                                        </tr>

                                    </table>

                                </td>
                            </form>
                        </c:forEach>
                    </tr>
                </table>
            </div>
            <!--Tab5 MUSIC-->
            <div id="forminfo5" class="tab-pane fade">
                <c:forEach var="MusicsList" items="${sessionScope.Music}">
                    <ul>
                        <li>${MusicsList.musicName}</li>
                        <%--  <li>${MusicsList.musicPath}</li>
         <li>
	           	<audio controls src="<spring:url value='/musics/${MusicsList.musicPath}'/>" type="audio/mp3"></audio>
        </li>  --%>
                        <li>
                            <audio controls>
                                <source src="<spring:url value='/musics/${MusicsList.musicPath}'/>" type="audio/mp3">
                            </audio>
                        </li>
                        <%-- <li>
        <embed src="musics/${MusicsList.musicPath}" ></embed>
           <embed src="<spring:url value='/musics/${MusicsList.musicPath}'/>" ></embed>
        </li> --%>
                    </ul>
                </c:forEach>
                <c:forEach var="MovieList" items="${sessionScope.Movie}">
                    <ul>
                        <li>${MovieList.movieName}</li>
                        <li>${MovieList.moviePath}</li>
                        <%--  <li>
	           	<audio controls src="<spring:url value='/musics/${MusicsList.musicPath}'/>" type="audio/mp4"></audio>
        </li>  --%>
                        <li>
                            <video controls>
                                <source src="<spring:url value='/movie/${MovieList.moviePath}'/>" type="video/mp4">
                            </video>
                        </li>

                    </ul>
                </c:forEach>

            </div>
        </div>
    </section>
    <section class="container col-sm-3">${sessionScope.table.uname}
        <table class="table table-responsive">
            <tr>
                <th>ITEM</th>
                <th>PRICE</th>
                <th>QUANTITY</th>
            </tr>
            <form action="<spring:url value='/Kitchen/placeOrderOrGetBill'/>">
                <c:forEach var="order" items="${sessionScope.order}">

                    <tr>
                        <td>${order.item}</td>
                        <td>${order.price}</td>
                        <td>${order.quantity}</td>
                        <td><a
                                href="<spring:url value='/Restaurant/DeleteOrderByOrderId?tid=${sessionScope.table.uname}&oid=${order.orderId}'/>">X</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><input type="hidden" value="${sessionScope.table.uname}" name="tid"></td>
                </tr>

                <tr>
                    <td><input class="btn btn-success" name="button" type="submit" value="Place an Order"
                            data-toggle="modal" data-target="#myModal1"></td>
                </tr>
                <tr>
                    <td><input class="btn btn-primary" name="button" type="submit" value="Get Bill"></td>
                </tr>
            </form>
        </table>

    </section>
</body>

</html>