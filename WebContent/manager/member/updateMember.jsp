<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h2>회원수정</h2>
				<div id="container_box">
					<form action="updateMember.do" method="post"
						enctype="multipart/form-data" name="frm">

						<table border="1">
							<tr>
								<th style="width: 80px">아이디</th>
								<td><input type="text" name="userid"
									value="${mVo.userid}" style="border: none; background-color:transparent;" readonly></td>
							</tr>
							<tr>
								<th style="width: 80px">이름</th>
								<td><input type="text" name="name" value="${mVo.name}" style="border: none; background-color:transparent;" readonly></td>
							</tr>
							<tr>
								<td>패스워드 변경</td>
								<td>
									<input type="password" name="pwd">*
									<input type="hidden" name="beforeid" value="${mVo.pwd}">
								</td>
							</tr>
							<tr>
								<td>패스워드 확인</td>
								<td><input type="password" name="pwd_check">*</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><input type="text" name="email" value="${mVo.email}"></td>
							</tr>
							<tr>
								<th>phone</th>
								<td><input type="text" name="phone" value="${mVo.phone}"></td>
							</tr>
						</table>


						<input type="hidden" name="userid" value="${member.userid}">
						<input type="submit" value="수정"> <input type="reset"
							value="취소"> <input type="button" value="목록"
							onclick="location.href='memberList.do'">
					</form>
				</div>
			</div>

		</section>



	</div>

</body>
</html>