<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Admin modify order</title>
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
				<h2>주문수정</h2>
				<div id="container_box">
					<form action="updateOrder.do" method="post"
						enctype="multipart/form-data" name="frm">
						<table border="1">

							<tr>
								<th style="width: 80px">상품명</th>
								<td><input type="text" name="name" value="${product.name}"></td>
							</tr>
							<tr>
								<th>가격</th>
								<td><input type="text" name="price"
									value="${product.price}"></td>
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
							<tr>
								<th>배송 주소</th>
								<td><input type="text" name="arrivalAdd"
									value="${product.arrivalAdd}"></td>
							</tr>


						</table>

						<input type="hidden" name="code" value="${product.code}">
						<input type="submit" value="수정"> <input type="reset"
							value="취소"> <input type="button" value="목록"
							onclick="location.href='orderList.do'">
					</form>
		</section>



	</div>

	</script>
</body>
</html>