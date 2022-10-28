<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/NewFile2.css">
<script type="text/javascript" src="script/qna.js"></script>
<title>검색창</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form name="search" action="searchQna.do">
				<table class="pull-right">
					<tr>
						<td><select name="column">
								<option value="0">선택</option>
								<option ${(param.column=="title")?"selected":""} value="title">제목</option>
								<option ${(param.column=="userId")?"selected":""} value="userId">작성자</option>
								<option ${(param.column=="content")?"selected":""} value="content">내용</option>
							</select>
						</td>
						<td><input type="text" placeholder="검색어 입력" name="keyword" maxlength="50" value="${param.keyword}"></td>
						<td><button type="submit" class="btn2 btn-success" onclick="return clickempty()">검색</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>