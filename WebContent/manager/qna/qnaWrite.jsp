<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="css/product1.css">
<script type="text/javascript" src="script/qna.js"></script>
<title>게시글 작성</title>
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
					<form method="post" action="qnaWrite.do" name="frm"
						enctype="multipart/form-data">
						<%-- <input type="hidden" name="board_id" value="${sessionScope.sessionID}"> --%>
						<table class="table table-striped"
							style="text-align: center; margin: 0 auto; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th colspan="2"
										style="background-color: #eeeeee; text-align: center;">Q
										& A</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="text" class="form-control"
										placeholder="글 제목" name="bbsTitle" maxlength="50"></td>
								</tr>
								<tr>
									<td><textarea class="form-control" placeholder="글 내용"
											name="bbsContent" maxlength="2048" style="height: 350px;"></textarea></td>
								</tr>
								<tr>
									<td><input type="file" name="fileP"></td>
								</tr>
							</tbody>
						</table>
						<br> <input type="submit" class="btn btn-primary pull-right"
							value="글쓰기" onclick="return checkQna()"> <br>
					</form>
				</div>
			</div>


		</section>
	</div>
</body>
</html>