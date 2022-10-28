<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin new sales</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/product1.css">

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
				<h2>오늘 매출</h2>

				<%-- 	${productList} --%>
				<table id="salesToday" border="1" >
					<tr>
						<th>상품명</th>
						<th>가 격</th>

					</tr>
					<c:forEach var="product" items="${salesTodayList}">

						<tr align="center">
							<td>${product.name}</td>
							<td>${product.price}</td>
						</tr>
					</c:forEach>
				</table>
				<input type="button" value="오늘 매출 상세 목록"
							onclick="location.href='salesToday.do'">

				<%-- ${message} --%>
			</div>
			<div align="center">
				<h2>한달 매출</h2>

				<%-- 	${productList} --%>
				<table id="salesMonth" border="1" >
					<tr>
						<th>상품명</th>
						<th>가 격</th>

					</tr>
					<c:forEach var="product" items="${salesMonthList}">

						<tr align="center">
							<td>${product.name}</td>
							<td>${product.price}</td>
						</tr>
					</c:forEach>
				</table>
				<input type="button" value="한달 매출 상세 목록"
							onclick="location.href='salesMonth.do'">
				<%-- ${message} --%>
			</div>
		</section>
	</div>
</body>
</html>