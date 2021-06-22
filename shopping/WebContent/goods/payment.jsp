<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	결제페이지입니다
	<form action="doPayment.gd" method="post">
	<input type ="hidden" name="purchaseNum" value="${paymentApprPrice }">
	<input type ="hidden" name="paymentApprPrice" value="${purchaseTotPrice }">
	<table>
		<tr><td>구매번호</td><td>${purchaseNum }</td></tr>
		<tr><td>결제금액</td><td>${purchaseTotPrice }원</td></tr>
		<tr><td>결제방법</td><td>카드</td></tr>
		<tr><td>카드번호</td><td><input type="text" name="paymentNumber"></td></tr>
		<tr><td align ="center" colspan="2"></td><td><input type="submit" vlaue="결제완료"> </td></tr>
	</table>
	</form>
</body>
</html>