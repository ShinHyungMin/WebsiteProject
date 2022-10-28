<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.shop.dao.ProductDao"%>
<%@page import="com.shop.dto.ProductVo"%>
<%@page import="java.util.List"%>

<%
ProductDao pDao = ProductDao.getInstance();
ProductVo pVo = new ProductVo();

//모든 상품 리스트를 디비로 부터 조회하여 저장
List<ProductVo> productList = pDao.selectAllProduct();
request.setAttribute("productList", productList);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>6조샵</title>
	<script type="text/javascript" src="script/member.js"></script>
<script type="text/javascript">
function fnCart() {
	//alert("Name : " + name + "\nPrice : " + price);
	if(confirm("장바구니에 담았습니다.")){
		
	}
}
function fnView() {
	if(confirm("장바구니를 보시겠습니까?")){
		location.href = "cart.jsp";
	}
}

function delchk(){
    if(confirm("장바구니에 담겠습니까?")){
        location.href = "";
        return true;
    } else {
        return false;
    }
}
</script>	
	<link rel="stylesheet" href="./css/NewFile2.css">
</head>
<body>
<%@ include file="html/header1.jsp" %>
<%@ include file="html/header2.jsp" %>
<br><br><br><br>
<div>
<ul class="best_product">
<c:forEach var="product" items="${productList}">
	<li><a href="thirdPage.jsp">
			<img src="image/${product.pictureurl}" width="280px" height="340px">
		</a>
			<div>
			품명 : ${product.name} <br>
			가격 : ${product.price} 원 <br>
			<p onclick="fnCart()" ><a class="btn btn-primary" href="cartDetail.do?code=${product.code} ">장바구니 담기</a></p>
			</div>		
	</li>
</c:forEach>
</ul>
</div>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

<%@ include file="html/footer.jsp" %>
</body>
</html>