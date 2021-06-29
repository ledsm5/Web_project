<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	

<input type="hidden" name="noticeNo" value="${dto.noticeNo }">
	<table border=1 width="600" align="center">	
		<tr><td>게시글 번호 : </td><td>${dto.noticeNo }</td></tr>
		<tr><td>작성자 : </td><td>${dto.employeeId }</td></tr>
		<tr><td>제목 : </td><td>${dto.noticeSub }</td></tr>
		<tr><td>작성 일자 : </td><td>${dto.noticeDate }</td></tr>
		<tr><td>내용 : </td><td><textarea rows="6" cols="50" name="noticeCon" >${dto.noticeCon }</textarea></td></tr>
		<tr><td colspan="2"><img width="200" height="200" name="noticeFile" src="notice/upload/${dto.noticeFile }"></td></tr>
	</table>
	<input type="reset" value="이전" onclick="javascript:history.back();">
	<!-- 직원전용 -->
	<c:if test="${authInfo.grade != 1 }">
	<input type="button" value="게시글 삭제" onclick="javascript:location.href='noticeDelete.nt?noticeNo=${dto.noticeNo }'" />
	<input type="button" value="게시글 수정" onclick="javascript:location.href='noticeModifyForm.nt?noticeNo=${dto.noticeNo }'">
	</c:if>
</body>
</html>