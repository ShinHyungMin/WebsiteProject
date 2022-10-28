<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.shop.dto.ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.shop.dao.ProductDao"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/cart.css?after">
<script type="text/javascript">
 
 
function fnPay(){
	alert("결제 기능을 지원하지 않습니다.");
}
 
function fnClear(){
	
	if(confirm("장바구니를 비우시겠습니까?")) {
		location.href = "cartClear.do";	
	}
}
 
function fnGo(){
	location.href = "./index.jsp";
}
</script>
</head>
<body>
<%@ include file="header1.jsp" %>
<%@ include file="header2.jsp" %>

<body>

<div class="wrap" align="center">
	<table class="type09">
		<tr>
			<th><input type="checkbox" onclick=""></th>
			<th>이미지</th>
			<th>상품정보</th>
			<th>판매가</th>
			<th>수량</th>
			<th>상품 적립금</th>
			<th>배송비</th>
			<th>합계</th>
		</tr>

	<c:if test="${cartList.size() == 0}">
		<tr align='center'> 
			<td colspan= '9'>
				장바구니에 담긴 상품이 없습니다.	
			</td>
		</tr>
	</c:if>
		
		<c:forEach var="cartList" items="${cartList}">
            <tr>
                <td><input type="checkbox" onclick=""></th>
                <td><img src="image/${cartList.pictureurl}"  width="100px" height="100px"></th>
                <td>${cartList.name}</th>
                <td>${cartList.price}</th>
                <td>${cartList.cnt + 1}</th>
                <td>${cartList.price / 50}</th>
                <c:if test="${cartList.price > 50000}">             
                	<td>무료</th>
                </c:if>
                <c:if test="${cartList.price < 50000}">             
                	<td>3000</th>
                </c:if>
                <td>${cartList.price * (cartList.cnt + 1)}</th>
            
            
            </tr> 
        </c:forEach>
	</table>
</div>
<div class="aa" style= text-align:center;><br>
    <input type="button" value="상품 주문하기" onclick="fnPay()">
	<input type="button" value="장바구니 비우기" onclick="fnClear()">
	<input type="button" value="계속 쇼핑하기" onclick="fnGo()">
</div><br>



<%@ include file="footer.jsp" %>
</body>
</html>