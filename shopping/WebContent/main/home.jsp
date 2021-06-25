<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1,h5 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
  background-image: url('images/msn.jpg');
  min-height: 100%;
  background-position: center;
  background-size: 70%;
}
/* .header{
	color:#4B0082;
}
 */
</style>


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
      <c:if test="${empty authInfo }">

<div class="bgimg w3-display-container w3-text-white">
  <div class="w3-display-middle w3-jumbo">
  <!--   <p class="header">01온라인</p> -->
  </div>
  <div class="w3-display-topleft w3-container w3-xlarge">
    <p><button onclick="document.getElementById('contact').style.display='block'" class="w3-button w3-black">로그인</button></p>
  </div>
  <div class="w3-display-bottomleft w3-container">
    <p class="w3-xlarge">EA sports</p>
    <p class="w3-large">01 online game</p>
    <p>made by zeroone<a href="https://www.github.com/ledsm5" target="_blank">개발자 깃허브</a></p>
  </div>
</div>


<!-- Contact Modal -->
<div id="contact" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom">
    <div class="w3-container w3-black">
      <span onclick="document.getElementById('contact').style.display='none'" class="w3-button w3-display-topright w3-large">x</span>
      <h1>Contact</h1>
    </div>
    <div class="w3-container">
      <p>회원 정보를 입력해주세요 </p>
	  <form action="login.sm" method="get" name= "frm">
	  	<table border = 1 align = "center">
			<tr>
				<td colspan="3">
					<input type="checkbox" name="idStore" value="store" 
					<c:if test="${idExist != null }">checked</c:if>
					>아이디저장 | 
					<input type="checkbox" name="autoLogin" value="auto">
					자동로그인
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId" value="${isExist }" class="w3-input w3-padding-16 w3-border" /><span>${userFail }</span></td>
				<td rowspan="2"><input type="image" src="images/injic.jpg" width="120" alt="login" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPw" class="w3-input w3-padding-16 w3-border"/><span>${pwFail }</span></td>
			</tr>
			<tr>
				<td colspan="3">
					<a href="idSearch.mem">아이디 찾기</a>/<a href="#">비밀번호 찾기</a> |
					<a href="memAgree.mem">회원가입</a>
				</td>
			</tr>
		</table>   
      </form>
      </c:if>
    </div>
  </div>
</div>

<%-- <!-- 로그인 안되었을 때  -->
<c:if test="${empty authInfo }">
<form action="login.sm" method="get" name= "frm">
	<table border = 1 align = "center">
		<tr>
			<td colspan="3">
				<input type="checkbox" name="idStore" value="store" 
				<c:if test="${idExist != null }">checked</c:if>
				>아이디저장 | 
				<input type="checkbox" name="autoLogin" value="auto">
				자동로그인
			</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId" value="${isExist }" /><span>${userFail }</span></td>
			<td rowspan="2"><input type="image" src="images/injic.jpg" width="120" alt="login" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPw"/><span>${pwFail }</span></td>
		</tr>
		<tr>
			<td colspan="3">
				<a href="idSearch.mem">아이디 찾기</a>/<a href="#">비밀번호 찾기</a> |
				<a href="memAgree.mem">회원가입</a>
			</td>
		</tr>
	</table>
</form>
</c:if>

 --%>



<c:if test="${!empty authInfo }">
<!-- 로그인 되었을 때 -->
	<c:if test="${authInfo.grade ==1}">
		<!-- 일반 회원 -->
			<a href="myPage.mem">마이페이지</a>
			<a href="goodsCartList.gd"> 장바구니</a>
			<a href="noticeMain.nt">공지사항</a>
			<a href="purchaseCon.gd">주문확인	</a>
	</c:if>
	<c:if test="${authInfo.grade !=1 }">
		<!-- 직원 -->
			<a href="goodsList.gd">상품등록</a>
			<a href="myPage.em">마이페이지</a> 
			<a href="noticeMain.nt">공지사항</a>
			<a href ="salesTable.sl">판매현황</a>
			<!-- 관리자 -->
		<c:if test="${authInfo.userId ==111 }">
				<a href="empList.em">직원 리스트</a>
				<a href="memList.mem">회원 리스트</a>
		</c:if>
	</c:if>
	<a href ="logout.sm"> 로그아웃 </a>
</c:if>
<%-- 
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

 --%>









