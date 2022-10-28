<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
회원정보 수정 페이지<br>
'*' 표시는 필수입력 항목입니다.

<form action="updateMember.do" method="post" name="frm3">
<table>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="${mVo.name}" style="border: none; background-color:transparent;" readonly></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userid" value="${mVo.userid}" style="border: none; background-color:transparent;" readonly></td>
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
		<td>이메일</td>
		<td><input type="text" name="email" value="${mVo.email}"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="phone" value="${mVo.phone}"></td>
	</tr>
	<tr>
		<td>등급</td>	
		<td><input type="radio" name="admin" value="0" checked="checked">일반회원</td>
		<td><input type="radio" name="admin" value="1">관리자</td>
	</tr>
	<tr>
		<td><input type="submit" value="확인" onclick="return checkJoin2()"></td> &nbsp;&nbsp;&nbsp;
		<td><input type="reset" value="취소"></td>
	</tr>
</table>
</form>
</body>
</html>