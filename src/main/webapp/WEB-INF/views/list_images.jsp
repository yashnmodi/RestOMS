<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List Images</title>
</head>

<body>
	<!-- <img src="images/login.jpg"/> -->
	<c:forEach var="breakFastMenu" items="${sessionScope.breakfast_list}">

		<ul>
			<li>${breakFastMenu.item}</li>
			<li>${breakFastMenu.price}</li>
			<li><img alt="No Image found" width="50px" height="50px"
					src="<spring:url value='/uploadimages/${breakFastMenu.imgPath}'/>"></li>
		</ul>
	</c:forEach>

	<c:forEach var="MusicsList" items="${sessionScope.Music}">
		<ul>
			<li>${MusicsList.musicName}</li>
			<li>${MusicsList.musicPath}</li>
			<li>
				<embed src="musics/${MusicsList.musicPath}" type="audio/mpeg"></embed>
				<%-- <embed src="musics/${MusicsList.musicPath}" type="audio/mpeg"></embed> --%>
			</li>
			<%-- <li>
<audio controls>
 <source type="audio/mpeg" src="<spring:url value='/musics/${MusicsList.musicPath}'/>">
</audio>
</li> 
 --%>
			<%--  <li>
<audio controls>
 <source type="audio/mpeg" src="http://localhost7070/musics/${MusicsList.musicPath}" >
</audio>
</li>  --%>

		</ul>
	</c:forEach>

</body>

</html>