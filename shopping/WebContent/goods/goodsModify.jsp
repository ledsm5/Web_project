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
		<form action="goodsModify.gd" method="post" name="frm" > <!-- 기본설정 되있는데  multipart로 바꾸면 파일을 날릴수있다  --><!-- enctype="multipart/form-data"  파일이없을때는 쓰면안도미 -->
		<input type ="hidden" name="prodNum" value="${dto.prodNum }">
		<table border=1 align="center" >
			<tr>
				<th>상품번호</th>
				<td>${dto.ctgr }-${dto.prodNum }</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type ="text" name="prodName" value="${dto.prodName }"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type ="text" name="prodPrice" value="${dto.prodPrice }"></td>
			</tr>
			<tr>
				<th>용량</th>
				<td><input type ="text" name="prodCapacity" value="${dto.prodCapacity }"></td>
			</tr>
			<tr>
				<th>공급처</th>
				<td><input type ="text" name="prodSupplyer" value="${dto.prodSupplyer }"></td>
			</tr>
			<tr>
				<th>배송비</th>
				<td><input type ="number" name="prodDelFee" min="0" step="1" value="${dto.prodDelFee }"></td>
			</tr>
			<tr>
			
				<th>추천여부</th>
				<td>
					<input type ="radio" name="recommand" value="Y" <c:if test="${dto.recommand.trim() == 'Y' }">checked</c:if> >추천
					<input type ="radio" name="recommand" value="N" <c:if test="${dto.recommand.trim() == 'N' }">checked</c:if> >비추
				</td>
			</tr>
			<tr>
				<th>내용</th><td><textarea rows="6" cols="50" name="prodDetail"> ${dto.prodDetail }</textarea></td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="상품등록">
					<input type="reset" value="취소" onclick="javascript:history.back();">
					<input type="button" value="홈으로" onclick="javascript:location.href='main.sm.">
				</td>
			</tr>
		</table>
	
	
	</form>
</body>
</html>