<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="#" method="post" name="frm" enctype="multipart/form-data">
	<input type="hidden" name="noticeNo" value="${dto.noticeNo }">
		<table>
			<tr><td>게시글 번호 : </td><td>${dto.noticeNo }</td></tr>
			<tr><td>작성자 :</td><td>${dto.employeeId }</td></tr>
			<tr><td>제목 :</td><td><input type = "text" name="noticeSub" value="${dto.noticeSub }"></td></tr>
			<!-- <tr><td>작성 일자 :</td><td><input type="date" id="now_date" name="noticeDate"></td></tr> -->
			<tr><td>내용 :</td><td><textarea rows="6" cols="50" name="noticeCon" >${dto.noticeCon }</textarea></td></tr>
			<tr><td colspan="2"><input type ="file"  name="noticeFile" src="notice/upload/${dto.noticeFile }"></td></tr>					
		</table>
		<!-- <input type="submit" value="수정">	 -->
	</form>
	<input type="button" value="게시글 수정" onclick="javascript:location.href='noticeModify.nt?noticeNo=${dto.noticeNo }'" />
</body>
</html>