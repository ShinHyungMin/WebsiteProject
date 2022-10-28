<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/product1.css">

<script type="text/javascript" src="script/qna.js"></script>
<title>공지사항 보기</title>
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
				<form action="noticeDelete.do" method="post">
					<div class="container">
						<div class="row">
							<table class="table table-striped"
								style="text-align: center; margin: 0 auto; border: 1px solid #dddddd">
								<thead>
									<tr>
										<th colspan="2"
											style="background-color: #eeeeee; text-align: center;">공지사항</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td align="left" maxlength="50">제목 : ${notice.title}</td>
									</tr>
									<tr>
										<td align="left" maxlength="50">작성자 : 관리자</td>
									</tr>
									<tr>
										<td align="left" maxlength="2048" style="height: 350px;">${notice.content}</td>
									</tr>
								</tbody>
							</table>
							<tr>
								<td><br> <input type="button"
									class="btn btn-primary pull-right" value="목록"
									onclick="location.href='noticeList.do'">
									&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
									<c:if test="${sessionScope.userId=='realhm'}">
										<input type="hidden" name="num" value="${notice.num}">
										<input type="submit" class="btn btn-primary pull-right"
											value="삭제" onclick="return clickDelete()">
										<a href="noticeUpdate.do?num=${notice.num}"
											class="btn btn-primary pull-right">수정</a>
									</c:if> <br>
						</div>
					</div>
				</form>
			</div>

		</section>
	</div>
</body>
</html>