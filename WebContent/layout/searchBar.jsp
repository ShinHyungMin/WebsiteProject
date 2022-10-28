<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./NewFile2.css">
<title>검색창</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form method="post" name="search" action="searchbbs.jsp">
				<table class="pull-right">
					<tr>
						<td><select name="searchField">
								<option value="0">선택</option>
								<option value="bbsTitle">제목</option>
								<option value="userID">작성자</option>
								<option value="userID">내용</option>
							</select>
						</td>
						<td><input type="text" placeholder="검색어 입력" name="searchText" maxlength="50"></td>
						<td><button type="submit" class="btn2 btn-success">검색</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>