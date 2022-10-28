<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
<link rel="stylesheet" href="css/sign_up.css">
</head>
<body>
<%@ include file="../html/header1.jsp" %>
<%@ include file="../html/header2.jsp" %>

    <div class="container">
        <center class="center">회원가입</center>
    </div>
    
    <div class="login-wrapper">
        <form method="post" action="join.do" name="frm" id="login-form">
            <input type="text" name="userid" placeholder="아이디" id="userid">
			<input type="hidden" name="checkid">
			<input type="button" value="중복확인 "onclick="checkId()">

            <input type="password" name="pwd" placeholder="비밀번호">
            <input type="password" name="pwd_check" placeholder="비밀번호 확인">
            <input type="text" name="name" placeholder="이름">
            <input type="text" name="phone" placeholder="휴대전화">
            <input type="text" name="email" placeholder="이메일">
       
			<input type="submit" value="확인" onclick="return checkJoin()"> &nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소" onclick="location.href='login.do'">
        </form>
    </div>
<%@ include file="../html/footer.jsp" %>
</body>
</html>