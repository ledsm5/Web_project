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
	<!-- 공용 공지사항 게시판  -->
	공지사항 페이지 입니다 
	<table border=1 width="600" align="center">
		<caption>* 공지사항 *</caption> 
			<tr><th>게시글번호</th><td>제목</td><td>등록일</td><td>조회수</td></tr>
			
			<c:forEach items="${list2 }" var="dto">				
				<tr>
			   <%-- <th><a href = "noticeDetail.nt?noticeNo = ${dto.noticeNo }">${dto.noticeNo }</a></th> --%>
					<th><a href="noticeDetail.nt?noticeNo=${dto.noticeNo }">${dto.noticeNo }</a></th>
					<td>${dto.noticeSub }</td>
					<td>${dto.noticeDate }</td>
					<td>${dto.noticeCount }</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="4">
					<!-- 직원전용 기능  -->
						<input type="button" value="게시글 작성" onclick="javascript:location.href='noticeRegist.nt';">
						<input type="button" value="홈으로" onclick="javascript:location.href='main.sm'"/> 
						<input type="reset" value="이전" onclick="javascript:history.back();">
					</td>
				</tr>
	</table>	
</body>
</html>