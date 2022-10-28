<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>header2</title>
	<link href="${pageContext.request.contextPath}/NewFile2.css" rel="stylesheet">
	<%-- <link href="<c:url value='NewFile2.css'/>" rel="stylesheet"> --%>
</head>
<body link="black" vlink="black" alink="black">
<div class="menu">
<ul>
	<li><a href="thirdPage.jsp">BEST</a></li> 
	<li><a href="thirdPage.jsp">아우터</a>
		<ul class="sub">
			<li><a href="thirdPage.jsp">코트</a></li>
			<li><a href="thirdPage.jsp">자켓</a></li>
			<li><a href="thirdPage.jsp">패딩</a></li>
		</ul>
	</li>
	<li><a href="thirdPage.jsp">상의</a>
		<ul class="sub">
			<li><a href="thirdPage.jsp">티셔츠</a></li>
			<li><a href="thirdPage.jsp">후드</a></li>
			<li><a href="thirdPage.jsp">셔츠</a></li>
			<li><a href="thirdPage.jsp">니트</a></li>
		</ul>
	</li> 
	<li><a href="thirdPage.jsp">하의</a>
		<ul class="sub">
			<li><a href="thirdPage.jsp">청바지</a></li>
			<li><a href="thirdPage.jsp">트레이닝</a></li>
			<li><a href="thirdPage.jsp">반바지</a></li>
			<li><a href="thirdPage.jsp">슬랙스</a></li>
		</ul>
	</li>	
	<li><a href="thirdPage.jsp">악세서리</a>
		<ul class="sub">
			<li><a href="thirdPage.jsp">반지</a></li>
			<li><a href="thirdPage.jsp">목걸이</a></li>
			<li><a href="thirdPage.jsp">가방</a></li>
		</ul>
	</li>		
</ul>
</div>
</body>
</html>