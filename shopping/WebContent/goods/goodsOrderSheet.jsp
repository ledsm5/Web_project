<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	주문서
	<hr/>
	<p>
	1.주문상품<br>
	<form action="goodsOrder.gd" method="get">
	<table width = "600">
		<tr>
			<td colspan="2">상품정보</td>
			<td>적용금액</td>
			<td>판매자</td>
			<td>배송비</td>
		</tr>
	<c:set var="cartPrice" value="0"/>
	<c:set var="cartDelFee" value="0"/>
	<c:set var="prodNums" value=""/>
	<c:forEach items="${list }" var="dto">
		<tr>
			<td>
				<img src="goods/upload/${dto.productDTO.prodImage.split(',')[0] }" width="50"/>
			</td>
			<td>상품명<br>
				${dto.productDTO.prodName }&nbsp;&nbsp;&nbsp;
				${dto.cartDTO.cartQty }개/
				${dto.productDTO.prodPrice }원
			</td>
			<td>${dto.cartDTO.cartPrice }</td>
			<td>${dto.productDTO.prodSupplyer }</td>
			<td>${dto.productDTO.prodDelFee }</td>
		</tr>
	<c:set var="cartPrice" value="${cartPrice + dto.cartDTO.cartPrice }"/>
	<c:set var="prodDelFee" value="${prodDelFee + dto.productDTO.prodDelFee }"/>
	<c:set var="prodNums" value="${prodNums += dto.productDTO.prodNum += ','}" />
	</c:forEach>
	</table>
	<table width="600">
			<tr>
				<td>상품금액<br />${cartPrice }</td>
				<td>+</td>
				<td>배송비<br />${prodDelFee }</td>
				<td>=</td>
				<td>최종결제금액<br />${cartPrice + prodDelFee } 
				<input type="text"name="purchaseTotPrice" value="${cartPrice + prodDelFee }" /> 
				<input type="text" name="prodNums" value="${prodNums }" />
				</td>
			</tr>
		</table>
		</p>
		<hr/>
		<p>
		2. 배송지 정보 입력
	<table>
		<tr><td>이름</td><td><input type="text" name="receiverName"></td></tr>
		<tr><td>주소</td><td><input type="text" name="purchaseAddr"></td></tr>
		<tr><td>연락처</td><td><input type="text" name="receiverPhone"></td></tr>
		<tr><td>주문메세지</td><td><input type="text" name="purchaseRequest"></td></tr>
		<tr>
			<td>결제방법</td>
			<td>
				<select name="purchaseMethod">
					<option>카드</option>
					<option>카카오페이</option>
				</select>
			</td>
		</tr>
	</table>
	<table>
		<tr><td><input type="submit" value="결제하기"></td></tr>	
	</table>
	<p/>
	</form>
</body>
</html>