<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${idFail == null }">
	${dto.memName }님의  아이디는 ${dto.memId } 입니다 <br>
</c:if>
<c:if test="${idFail !=null }">
	${idFail }
</c:if>
	<a href="main.sm">메인으로 </a>
</body>
</html>