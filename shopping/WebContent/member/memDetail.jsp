<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	나의 상세정보 <br>
	
	아이디 : ${dto.memId } <br>     		<!-- dto는   MemberDetailPage 의 dto  -->
	이름 : ${dto.memName } <br>
	생년월일 :  ${dto.memBirth } <br>
	성별 : ${dto.memGender } <br>
	우편번호: ${dto.postNumber } <br>
	주소 : ${dto.memAddress } <br>
	상세주소 : ${dto.detailAdd } <br>
	연락처 : ${dto.memPhone } <br>
	이메일 : ${dto.memEmail } <br>
	계좌번호 : ${dto.memAccount } <br>
	수신여부 :  
		<c:if test ="${dto.memEmailCk == 'Y'}">이메일 수신함 </c:if>
		<c:if test ="${dto.memEmailCk == 'N'}">이메일 수신 안함</c:if><br>
		<a href ="memSujung.mem">수정</a>
		<%-- <a href = "memMod.mem?memId=${dto.memId }">수정</a>     다르게 주는 이유 ! ==> 세션을 쓰면 굳이   memId 로 꼬리를 날릴필요가 없다.--%>
</body>
</html>