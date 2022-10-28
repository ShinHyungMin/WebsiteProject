<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Admin_user</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/product1.css">


</head>
<body>
	<div id="manager_root">
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
				<h2>회원 리스트</h2>

				<%-- 	${memberList} --%>
				<table border="1">
					<tr>
						<th>아이디</th>
						<th>이름</th>						
						<th>이메일</th>
						<th>모바일</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
					<c:forEach var="member" items="${memberList}">
						<tr align="center">
							<td>${member.userid}</td>
							<td>${member.name}</td>							
							<td>${member.email}</td>
							<td>${member.phone}</td>
							<td><a href="updateMember.do?userid=${member.userid}">회원수정</a></td>
							<td><a href="deleteMember.do?userid=${member.userid}">회원삭제</a></td>
						</tr>
					</c:forEach>
				</table>
				<%-- ${message} --%>
			</div>


	</div>
</body>
</html>