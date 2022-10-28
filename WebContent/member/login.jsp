<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="script/member.js"></script>
	<link rel="stylesheet" href="css/login.css">

</head>
<body>
<%@ include file="../html/header1.jsp" %>
<%@ include file="../html/header2.jsp" %>
    <div class="container">
        <center class="center">LOGIN</center>
    </div>
    <div class="login-wrapper">
        <form method="post" action="login.do" id="login-form" name="frm">
            <input type="text" name="userId" placeholder="id">
            <input type="password" name="userPwd" placeholder="Password">
            <label for="remember-check">
                <input type="checkbox" id="remember-check">아이디 저장하기
            </label>
            <input type="submit" value="로그인" onclick="return checkLogin()">
            <input type="button" value="회원가입" onclick="location.href='join.do'">
            <div>
                <h4>아직도 회원이 아니세요?</h4><br>
                <div class="Sign_Up">
                    지금 6조샾의 회원이 되어 다양한 이벤트에 참여해 보세요.<br>
                    회원만의 특별한 혜택을 가장 먼저 만나보세요.
                </div>
            </div>
        </form>
    </div>
    <div class="box">
        <div class="explan">
            <div class="explan_img">
                <img src="team/image/main.jpg" alt="">
                
            </div>
                
            <div>
                - 2,000원 적립금 지급<br>
                - 신상 24시간 10% 할인<br>
                - 세일 상품 및 특별세일<br>
            </div>
        </div>   
        <div class="explan">
            <div class="explan_img">
                <img src="team/image/main.jpg" alt="">
                
            </div>
                
            <div>
                - 2,000원 적립금 지급<br>
                - 신상 24시간 10% 할인<br>
                - 세일 상품 및 특별세일<br>
            </div>
        </div>   
        <div class="explan">
            <div class="explan_img">
                <img src="team/image/main.jpg" alt="">
                
            </div>
                
            <div>
                - 2,000원 적립금 지급<br>
                - 신상 24시간 10% 할인<br>
                - 세일 상품 및 특별세일<br>
            </div>
        </div>   
        <div class="explan">
            <div class="explan_img">
                <img src="team/image/main.jpg" alt="">
                
            </div>
                
            <div>
                - 2,000원 적립금 지급<br>
                - 신상 24시간 10% 할인<br>
                - 세일 상품 및 특별세일<br>
            </div>
        </div>
    </div>
    <%@ include file="../html/footer.jsp" %>
</body>
</html>