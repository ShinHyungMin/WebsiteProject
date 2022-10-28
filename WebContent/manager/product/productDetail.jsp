<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>delete product</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/product1.css">


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
				<h2>상품상세</h2>
				<div id="container_box">
					<form action="delete.do" method="post">
						<table border="1">
							<tr>
								<td align="center"><c:choose>
										<c:when test="${empty product.pictureurl}}">
											<img src="images/2.jpg">
										</c:when>
										<c:otherwise>
											<img src="image/${product.pictureurl}">
										</c:otherwise>
									</c:choose></td>
								<td>
									<table border="1">
										<tr>
											<th style="width:100px">상품명</th>
											<td style="width:200px" align="center">${product.name}</td>
										</tr>
										<tr>
											<th>가 격</th>
											<td align="center">${product.price}</td>
										</tr>
										<tr>
											<th>설 명</th>
											<td align="center">${product.description}</td>
										</tr>
										<tr>
											<th>등록 일자</th>
											<td align="center">${product.reg_date}</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>

						<input type="button" value="목록" onclick="location.href='productList.do'">

					</form>
					</div>
					</div>
		</section>


	</div>


</body>
</html>