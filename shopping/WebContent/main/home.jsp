<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function goodsBuy(prodNum){
	if(${authInfo == null}){
		alert("로그인을 하셔야 합니다.");
		return false;
	}else{
		location.href='prodInfo.gd?prodNum='+prodNum;
	}
}
</script>
</head>
<body>
<!-- 로그인 안되었을 때  -->
<c:if test="${empty authInfo }">
<form action="login.sm" method="get" name= "frm">
	<table border = 1 align = "center">
		<tr>
			<td colspan="3">아이디저장 | 자동로그인</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId"/><span>${userFail }</span></td>
			<td rowspan="2"><input type="image" src="images/injic.jpg" alt="login" width="120"/></td><!-- webcontent가 시작점  -->
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPw"/><span>${pwFail }</span></td>
		</tr>
		<tr>
			<td colspan="3">
				<a href="#">아이디</a>/<a href="#">비밀번호 찾기</a> |
				<a href="memAgree.mem">회원가입</a>
			</td></tr>
	</table>

</form>
</c:if>
<c:if test="${!empty authInfo }">
<!-- 로그인 되었을 때 -->
	<c:if test="${authInfo.grade ==1}">
		<!-- 일반 회원 -->
			<a href="myPage.mem">마이페이지</a>
			<a href="goodsCartList.gd"> 장바구니</a>
			<a href="noticeMain.nt">공지사항</a>
			<a href="purchaseCon.gd">주문확인</a>
	</c:if>
	<c:if test="${authInfo.grade !=1 }">
		<!-- 관리자 -->
		<a href="goodsList.gd">상품등록</a>
			<!-- 직원 -->
			<c:if test="${authInfo.userId ==111 }">
				<a href="empList.em">직원 리스트</a>
				<a href="memList.mem">회원 리스트</a>
				<a href ="logout.sm">로그아웃</a>
			</c:if>
				<a href="myPage.em">마이페이지</a> 
	</c:if>
	<a href ="logout.sm"> 로그아웃 </a>
</c:if>

<!-- 상품리스트 -->
<p></p>
<table align="center" border= "1">
	<tr>
	<c:forEach items ="${lists }" var="dto" varStatus="cnt">
		<td><a href="javascript:goodsBuy('${dto.prodNum}')"><img width="200" height="200" src="goods/upload/${dto.prodImage.split(',')[0] }"><br>
			${dto.prodName } <br>
			가격:<fmt:formatNumber value="${dto.prodPrice }" type="currency"/> <br>
		</a></td>
		<c:if test="${cnt.count % 3 == 0}">
		</tr><tr>
		</c:if>
	</c:forEach>
	</tr>
</table>
</body>
</html>
