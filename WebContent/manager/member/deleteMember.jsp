<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h2>회원삭제</h2>
				<div id="container_box">
					<form action="deleteMember.do" method="post">
						<table border="1">

							<tr>
								<th style="width: 80px">아이디</th>
								<td style="width: 80px">${member.userid}</td>
							</tr>
							<tr>
								<th>이름</th>
								<td style="width: 80px">${member.name}</td>
							</tr>
							<tr>
								<th style="width: 80px">이메일</th>
								<td style="width: 80px">${member.email}</td>
							</tr>
							<tr>
								<th style="width: 80px">모바일</th>
								<td style="width: 80px">${member.phone}</td>
							</tr>


						</table>
						<input type="hidden" name="userid" value="${member.userid}">
						<input type="submit" value="삭제"
							onclick="location.href='memberList.do'"> <input
							type="button" value="목록" onclick="location.href='memberList.do'">

					</form>
		</section>



	</div>


</body>
</html>