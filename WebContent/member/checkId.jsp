<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<h2>아이디 중복 확인</h2>
<form action="checkId.do" name="frm2">
아이디
	<input type="text" name="userid" value="${userid}">
	<input type="submit" value="중복 체크" >
	<br>
	<br>
	${message}
		
	<!-- 만약, 사용 불가능한 아이디인 경우 => 사용 버튼 미생성 -->
	<c:if test="${result==1}">
	<script type="text/javascript">
		opener.document.frm.userid.value="";
	</script>
	</c:if>
	
	<!-- 만약, 사용 가능한 아이디인 경우 => 사용 버튼 생성 -->
	<c:if test="${result==-1}">
		<input type="button" value="사용하기" onclick="idOk()">
	</c:if>

</form>
</body>
</html>