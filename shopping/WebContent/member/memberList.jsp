<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	회원 리스트 페이지입니다 <br>
	<table border=1>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>연락처</td>
			<td>이메일</td>
			<td>주소</td>
		</tr>
		<c:forEach items = "${lists }" var ="dto"> <!--for문으로 바꿔주는 명령문이 위에 링크에 걸려있다(쉽게쓰기위해서  -->
		<tr>
			<td><a href="memInfo.mem?memId=${dto.memId }">${dto.memId }</a></td>
			<td>${dto.memName }</td>
			<td>${dto.memPhone }</td>
			<td>${dto.memEmail }</td>
			<td>${dto.memAddress }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>