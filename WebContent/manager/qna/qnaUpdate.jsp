<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="css/product1.css">
<script type="text/javascript" src="script/qna.js"></script>
<title>게시글 수정</title>
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
				<div class="row">
					<form method="post" action="qnaUpdate.do" name="frm"
						enctype="multipart/form-data">
						<input type="hidden" name="board_id"
							value="${sessionScope.sessionID}">
						<table class="table table-striped"
							style="text-align: center; margin: 0 auto; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th colspan="2"
										style="background-color: #eeeeee; text-align: center;">Q
										& A 수정</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="text" class="form-control"
										value="${text.title}" name="bbsTitle" maxlength="50"></td>
								</tr>
								<tr>
									<td><textarea class="form-control" placeholder="글 내용"
											name="bbsContent" maxlength="2048" style="height: 350px;">${text.content}</textarea></td>
								</tr>
							</tbody>
						</table>
						<br> <input type="hidden" name="num" value="${text.num}">
						<input type="hidden" name="reg_date" value="${text.reg_date}">
						<input type="hidden" name="viewCnt" value="${text.viewCnt}">
						<input type="button" class="btn btn-primary pull-right" value="목록"
							onclick="location.href='qnaList.do'"> <input
							type="submit" class="btn btn-primary pull-right" value="수정"
							onclick="return checkQna()"> <input type="reset"
							value="취소"> <br>
					</form>
				</div>
			</div>


		</section>
	</div>
</body>
</html>