<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin new sales</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/product1.css">
<script type="text/javascript" src="script/salesTodaySum.js"></script>

</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="/../layout/managerHeader.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="/../layout/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="/../layout/aside.jsp"%>
			</aside>
			<div align="center">
				<h2>오늘 매출 확인</h2>

				<%-- 	${productList} --%>
				<table id="salesToday" border="1" >
					<tr>
						<th>코드</th>
						<th>상품명</th>
						<th>가 격</th>

					</tr>
					<c:forEach var="product" items="${salesTodayList}">

						<tr align="center">
							<td>${product.code}</td>
							<td>${product.name}</td>
							<td>${product.price}</td>
							
						</tr>
					</c:forEach>
				</table>
				<input type='button' value='오늘 매출 합계(원)' onclick='calcSum()' /><div id='sum'></div>

				<%-- ${message} --%>
			</div>
						<div align="center">
				<h2>오늘 주문 확인</h2>

				<%-- 	${productList} --%>
				<table border="1">
					<tr>
						<th>코드</th>
						<th>이름</th>
						<th>가격</th>
						<th>등록일자</th>
						<th>배송주소</th>						
						<th>주문수정</th>
						
					</tr>
					<c:forEach var="product" items="${orderList}">
					<tr align="center">
						<td>${product.code}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.reg_date}</td>
						<td>${product.arrivalAdd}</td>						
						<td><a href="updateOrder.do?code=${product.code}">주문수정</a></td>						
					</tr>
					</c:forEach>
				</table>
				<%-- ${message} --%>
			</div>
		</section>
	</div>
</body>
</html>