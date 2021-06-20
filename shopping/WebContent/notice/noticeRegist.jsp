<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="noticeRegistOk.nt" method="post" name="frm">
	<table>
		<tr><td>게시글 번호</td><td><input type ="text" name="noticeNo" readonly value="${noticeNo }"></td></tr>
		<tr><td>게시글 제목</td><td><input type ="text" name="noticeSub" value="${noticeSub }" ></td></tr>
		<tr><td>직원 아이디</td><td><input type ="text" name="empId" readonly value="${empId }"></td></tr>
		<tr><td>내용</td><td><textarea rows="6" cols="50" name="noticeCon" value="${noticeCon }" ></textarea></td></tr>
		<tr><td>작성날짜</td><td><input type="date" name="noticeDate" value="${noticeDate}"> </td></tr>
		<tr><td>사진첨부</td><td><input type="image" name="noticeFile" value="${noticeFile }"></td></tr>
		<tr>
			<td>
				<input type="submit" value="등록">
				<input type="button" value="이전" onclick="javascript:history.back();"/>
				
			</td>
		</tr>
	</table>
	</form>
</body>
</html>