<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/NewFile2.css">
<script type="text/javascript" src="script/qna.js"></script>
<title>게시글 보기</title>
</head>
<body>
<%@ include file="../html/header1.jsp" %>
<%@ include file="../html/header2.jsp" %>
<form action="qnaDelete.do" method="post" name="frm">
<div class="container">
	<div class="row">
			<table class="table table-striped" style="text-align: center; margin: 0 auto; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee;text-align: center;">Q & A</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td align="left" maxlength="50">제목 : ${text.title}</td>
					</tr>
					<tr>
						<td align="left" maxlength="50">작성자 : ${text.userId}</td>
					</tr>
					<tr>
						<td align="left" maxlength="2048" style="height: 350px;">
						<c:choose>
							<c:when test="${empty text.fileP}">
							</c:when>
							<c:otherwise>
								<img src="upload/${text.fileP}">
							</c:otherwise>
						</c:choose>
						<br>
						${text.content}
						</td>
					</tr>
				</tbody>
			</table>
				<tr>
					<td>
			<br>
			<input type="button" class="btn btn-primary pull-right" value="목록" onclick="location.href='qnaList.do'">
			<c:if test="${sessionScope.userId==text.userId || sessionScope.userId=='realhm'}">
				<input type="hidden" name="num" value="${text.num}">
				<input type="submit" class="btn btn-primary pull-right" value="삭제" onclick="return clickDelete()">
				<a href="qnaUpdate.do?num=${text.num}" class="btn btn-primary pull-right">수정</a>
			</c:if>			
			<br>
	 	</form>
	 </div>
</div>
<div id="disqus_thread"></div>
<script>
    /**
    *  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
    *  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables    */
    /*
    var disqus_config = function () {
    this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
    this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
    };
    */
    (function() { // DON'T EDIT BELOW THIS LINE
    var d = document, s = d.createElement('script');
    s.src = 'https://realhm.disqus.com/embed.js';
    s.setAttribute('data-timestamp', +new Date());
    (d.head || d.body).appendChild(s);
    })();
</script>
<noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;	
<%@ include file="../html/footer.jsp" %> 
</body>
</html>