<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA</title>
<link rel="stylesheet" type="text/css" href="css/product1.css">


</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../../layout/managerHeader.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../../layout/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<aside>
				<%@ include file="../../layout/aside.jsp"%>
			</aside>
			<div align="center">
				<h2>QnA</h2>
				<div class="row">
					<table class="table table-striped"
						style="text-align: center; margin: 0 auto; border: 1px solid #dddddd">
						<thead>
							<tr>
								<th style="background-color: #eeeeee; text-align: center;">번호</th>
								<th style="background-color: #eeeeee; text-align: center;">제목</th>
								<th style="background-color: #eeeeee; text-align: center;">작성자</th>
								<th style="background-color: #eeeeee; text-align: center;">작성일</th>
								<th style="background-color: #eeeeee; text-align: center;">조회수</th>
							</tr>
						</thead>
						<c:forEach var="text" items="${textList}">
							<tbody>
								<tr>
									<td>${text.num}</td>
									<td><a href="qnaDetail.do?num=${text.num}">${text.title}</td>
									<td>${text.userId}</td>
									<td>${text.reg_date}</td>
									<td>${text.viewCnt}</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					<br>
					<c:if test="${sessionScope.userId!=null}">
						<a href="qnaWrite.do" class="btn btn-primary pull-right">글쓰기</a>
					</c:if>
					<br>
<c:set var="page" value="${(empty param.p)?1:param.p}"></c:set>
<c:set var="startNum" value="${page - (page-1) %5}"></c:set>
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}"></c:set>					
<c:if test="${startNum>1}">
	<a href="?p=${startNum-1}">이전 </a>
</c:if>
<c:if test="${startNum <= 1}">
		<span onclick="alert('시작 페이지입니다.')"></span>
	</a>
</c:if>
<c:forEach var="i" begin="0" end="4">
	<c:if test="${(i+startNum) <= lastNum}">
		<a sytle="color:${(page==(i+startNum))?'blue':''}" href="?p=${i+startNum}&column=${param.column}&keyword=${param.keyword}">${i+startNum}</a>
	</c:if>
</c:forEach>

<c:if test="${startNum+4 < lastNum}">
<a href="?p=${startNum+5}">다음</a>
</c:if>

<c:if test="${startNum+4 >= lastNum}">
	<span onclick="alert('마지막 페이지입니다.')"></span>
</a>
</c:if>	
				</div>
			</div>
		</section>
	</div>
</body>
</html>