<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="css/NewFile2.css">
</head>
<body>
<%@ include file="../html/header1.jsp" %>
<%@ include file="../html/header2.jsp" %>
<div class="container">
<h2>공지사항</h2>
<c:set var="page" value="${(empty param.p)?1:param.p}"></c:set>
<c:set var="startNum" value="${page - (page-1) %5}"></c:set>
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}"></c:set>
<div class="pull-right"><span>${(empty param.p)?1:param.p}</span>/${lastNum} pages</div>
	<div class="row">
		<table class="table table-striped" style="text-align: center; margin: 0 auto; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th style="background-color: #eeeeee;text-align: center;">번호</th>
					<th style="background-color: #eeeeee;text-align: center;">제목</th>
					<th style="background-color: #eeeeee;text-align: center;">작성자</th>
					<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					<th style="background-color: #eeeeee; text-align: center;">조회수</th>
				</tr>
			</thead>
			<c:forEach var="notice" items="${noticeList}">
			<tbody>
				<tr>
					<td>${notice.num}</td>
					<td><a href="noticeDetail.do?num=${notice.num}">${notice.title}</td>
					<td>관리자</td>
					<td>${notice.reg_date}</td>
					<td>${notice.viewCnt}</td>
				</tr>							
			</tbody>
			</c:forEach>
		</table>
		<br>
		<c:if test="${sessionScope.userId=='realhm'}">
			<a href="noticeWrite.do" class="btn btn-primary pull-right">글쓰기</a>
		</c:if>		
		<br>
		<div class="text-center">	
			<ul class="pagination">
				<li>
					<c:if test="${startNum>1}">
						<a href="?p=${startNum-1}">이전 </a>
					</c:if>
					
					<c:if test="${startNum <= 1}">
							<span onclick="alert('시작 페이지입니다.')"></span>
						</a>
					</c:if>		
				</li>			
				<li>
				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(i+startNum) <= lastNum}">
						<a sytle="color:${(page==(i+startNum))?'orange':''}" href="?p=${i+startNum}&column=${param.column}&keyword=${param.keyword}">${i+startNum}</a>
					</c:if>
				</c:forEach>				
				</li>
				<li>
					<c:if test="${startNum+4 < lastNum}">
					<a href="?p=${startNum+5}">다음</a>
					</c:if>
					
					<c:if test="${startNum+4 >= lastNum}">
						<span onclick="alert('마지막 페이지입니다.')"></span>
					</a>
					</c:if>
				</li>						
			</ul>		
		</div>

		
	</div>
</div>
<%@ include file="./searchBarN.jsp" %>
<%@ include file="../html/footer.jsp" %>
</body>
</html>