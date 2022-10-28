<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Admin modify product</title>
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
				<h2>상품수정</h2>
				<div id="container_box">
					<form action="updateProduct.do" method="post"
						enctype="multipart/form-data" name="frm">
						<table border="1">
							<tr>
								<td><c:choose>
										<c:when test="${empty product.pictureurl}}">
											<img src="image/noimage.jpg" width="200px" height="200px">
										</c:when>
										<c:otherwise>
											<img src="upload/${product.pictureurl}" width="200px"
												height="200px">
										</c:otherwise>
									</c:choose></td>
								<td>
									<table border="1">
										<tr >
											<th style="width: 80px">상품명</th>
											<td><input type="text" name="name"
												value="${product.name}"></td>
										</tr>
										<tr>
											<th>가격</th>
											<td><input type="text" name="price"
												value="${product.price}"></td>
										</tr>
										<tr>
											<th>사진</th>
											<td><input type="file" name="pictureurl"><br></td>
										</tr>
										<tr>
											<th>설명</th>
											<td><input type="text" name="description"
												value="${product.description}"></td>
										</tr>
										<tr>
											<th>등록 일자</th>
											<td><input type="text" name="reg_date"
												value="${product.reg_date}"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>

						<input type="hidden" name="code" value="${product.code}">
						<input type="submit" value="수정"> <input type="reset"
							value="취소"> <input type="button" value="목록"
							onclick="location.href='productList.do'">
					</form>
				</div>
			</div>
		</section>



	</div>

</body>
</html>