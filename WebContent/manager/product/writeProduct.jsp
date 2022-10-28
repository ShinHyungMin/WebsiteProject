<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Admin new product</title>
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
				<h2>상품등록</h2>
				<div id="container_box">
					<form method="post" enctype="multipart/form-data" name="frm">
						<table border="1">

							<tr>
								<th>상품명</th>
								<td><input type="text" name="name"></td>
							</tr>
							<tr>
								<th>가격</th>
								<td><input type="text" name="price"></td>
							</tr>
							<tr>
								<th>사진</th>
								<td><input type="file" name="pictureurl"></td>
							</tr>
							<tr>
								<th>설명</th>
								<td><input type="text" name="description"></td>
							</tr>
							<tr>
								<th>등록일자</th>
								<td><input type="text" name="reg_date"></td>
							</tr>

						</table>
						<br> <input type="submit" value="등록"> <input
							type="reset" value="취소"> <input type="button" value="수정"
							onclick="location.href='updateProduct.do'"> <input
							type="button" value="삭제"
							onclick="location.href='deleteProduct.do'"> <input
							type="button" value="목록" onclick="location.href='productList.do'">
					</form>
		</section>



	</div>

	</script>
</body>
</html>