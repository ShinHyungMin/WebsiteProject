<%-- <%@ page import="jdk.internal.misc.FileSystemOption" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/NewFile2.css">
<title>header1</title>
</head>
<body>
<div class="topmenu">
<br>
<%
        // 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
        String id = (String) session.getAttribute("userId");
        if(id == null) {
%>
            <a href="login.do">로그인</a>&emsp;
			<a href="join.do"> 회원가입 </a>&emsp;
			<a href="cart.do"> 장바구니 </a>&emsp;
			<a href="aipage.jsp"> 쇼핑AI </a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href="noticeList.do"> 공지사항 </a>&emsp;
			<a href="qnaList.do"> Q&A </a>
			<form action="searchMain.do" style="float:right;margin:0;">
			<input type="text" placeholder="검색어 입력" name="keyword" value="${param.keyword}">&emsp;
			<button type="submit" class="btn2 btn-primary pull-right">검색</button>
			</form>            
<%          
            }
		
        // 현재 로그인된 아이디가 있다면 (= session에 저장된 id가 있다면)
        else {
%>
  <span style="color: blue;">${sessionScope.userId}</span>님&emsp;<a href="logout.do"><span style="color: blue;">로그아웃</span><!-- </a> -->&emsp;
						<a href="join.do"> 회원가입 </a>&emsp;
						<a href="cart.do"> 장바구니 </a>&emsp;
						<a href="aipage.jsp"> 쇼핑AI </a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						<a href="noticeList.do"> 공지사항 </a>&emsp;
						<a href="qnaList.do"> Q&A </a>&emsp;
						<input type="text" placeholder="검색어 입력" name="keyword" value="${param.keyword}">
						<a href="efef.jsp" class="btn2 btn-primary pull-right">검색</a>            
<%			
        }
%>

</div>
<hr>
<h1>
	<center>
		<a href="./index.jsp">6조샵</a>
	</center>
</h1>
<hr>
</body>
</html>