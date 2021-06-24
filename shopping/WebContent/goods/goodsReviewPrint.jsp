<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="reviewWrite.gd" method="post" enctype="multipart/form-data">  <!-- file 은 문자로 못날린다 get방식으로 날릴수 없다  -->
		<input type="hidden" name="prodNum" value="${prodNum }"> 
		<input type="hidden" name="purchaseNum" value="${purchaseNum }">
		<table>
			<tr>
				<td>리뷰</td>
				<td><textarea rows="5" cols="30" name="reviewContent"></textarea></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="reviewImg"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="리뷰등록"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>