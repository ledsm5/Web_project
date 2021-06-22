<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="goodsJoin.gd" method="post" name="frm" enctype="multipart/form-data" > <!-- 기본설정 되있는데  multipart로 바꾸면 파일을 날릴수있다  -->
		<table border=1>
			<tr>
				<th>상품번호</th>
				<td>
				<select name="ctgr">
					<option value="premierleague">프리미어리그</option>
					<option value="laliga">라리가</option>
					<option value="intenatioal">국가대표</option>
					<option value="etc">기타</option>
				</select>
				<input type ="text" name="goodsNum" value="${goodsNum }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>선수명</th>
				<td><input type ="text" name="prodName"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type ="text" name="prodPrice" maxlength="9"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type ="text" name="prodCapacity"></td>
			</tr>
			<tr>
				<th>주발</th>
				<td><input type ="text" name="prodSupplyer"></td>
			</tr>
			<tr>
				<th>별점</th>
				<td><input type ="number" name="prodDelFee" min="0" max="5" step="1"></td> <!-- 별뜨게 하기   -->
			</tr>
			<tr>
				<th>추천여부</th>
				<td>
					<input type ="radio" name="recommend" value="Y" checked>추천
					<input type ="radio" name="recommend" value="N">비추
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="6" cols="50"  name="prodDetail" ></textarea></td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
					<input type="file" name="prodImage1"> <br>
					<input type="file" name="prodImage2"> <br>
					<input type="file" name="prodImage3"> <br>
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="선수등록">
					<input type="reset" value="취소">
					<input type="button" value="홈으로" onclick="javascript:location.href='main.sm">
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>
