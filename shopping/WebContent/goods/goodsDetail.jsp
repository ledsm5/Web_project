<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function onQty(){
	var qty = document.frm.PurchaseQty.value;
	document.getElementById("tot").innerHTML = qty * ${dto.prodPrice}
}
function goodsCartAdd(prodNum){
	var qty = document.frm.PurchaseQty.value;
	location.href="goodsCartAdd.gd?prodNum="+prodNum + "&qty=" +qty+ "&prodPrice=${dto.prodPrice}";
}
</script>
</head>
<body>
<p><p>
<form action="#" name="frm" method="post">
<input type="hidden" name="prodNum" value="${dto.prodNum }"/>
	${dto.ctgr }의${dto.prodName } 상품설명입니다.
	<table width="800" align="center" border=1>
		<tr><td rowspan="5">
			<img height ="300" src="goods/upload/${dto.prodImage.split(',') [0] }">	
			</td><td></td>
		</tr>
		<tr><td>${dto.prodPrice }</td></tr>
		<tr><td><c:if test="${dto.prodDelFee == 0 }">무료배송</c:if></td></tr>
		<tr><td><c:if test="${dto.prodDelFee != 0 }">${dto.prodDelFee }원</c:if></td></tr>
		<tr><td><input type="number" min = "1" name="PurchaseQty" size="3" min="1" name="purchaseQty" size="3" value="1" onchange="onQty();">  
   
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${dto.prodPrice }</td></tr>
		<tr><td align = "right" >총 상품금액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span id="tot">${dto.prodPrice }</span></td></tr>
		<tr><td align="right">
				<input type="button" value="장바구니" onclick = "goodsCartAdd('${dto.prodNum }');"	/>
				<input type="submit" value="바로구매" > 	
			</td>
		</tr>
		<tr><td colspan ="2">용량 : ${dto.prodCapacity} <br>
				공급업체 : ${dto.prodSupplyer } <br>
				<c:forTokens items="${dto.prodImage }" delims="," var="file">
					<img src="goods/upload/${file }">
				</c:forTokens>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>