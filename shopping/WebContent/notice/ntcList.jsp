<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 공용 공지사항 게시판  -->
	공지사항 페이지 입니다 
	<table border=1 width="600" align="center">
		<caption>* 공지사항 *</caption> 
			<tr><th><a >게시글번호</a></th><td>제목</td><td>등록일</<td>조회수</td></tr>
			<c:forEach items="${lists }" var="dto">				
				<tr>
					<th><a href = "noticeDetail.nt?noticeNo = ${dto.noticeNo }">${dto.noticeNo }</a></th>
					<td>${dto.noticeSub }</td>
					<td>${dto.noticeDate }</td>
					<td>${dto.noticeCount }</td>
				</tr>
			</c:forEach>
	</table>
	
	<!-- 직원전용 기능  -->
	<a href ="noticeRegist.nt">공지사항 등록하기</a> <br>
	공지사항 삭제하기 
	<input type="reset" value="이전" onclick="javascript:history.back();">
	
	
</body>
</html>