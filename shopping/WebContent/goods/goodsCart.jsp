<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkQty(prodNum, prodPrice, cartQty){
		if(cartQty > 1){
			/* 서버단으로 넘기겠다  */
			location.href="goodsCartQtyDown.gd?prodNum="+prodNum+"&prodPrice=" +prodPrice/* a태그와 같은기능  */
		}else{
			/* 진행 x */
			alert("최소 수량은 1이상이어야 합니다.");
			return false;
		}
	}	
	function prodChk(){
		var prodTot = 0;
		var chk= document.getElementsByName("prodCk");
		var hddchk = document.getElementsByName("cartPrice");
		var cnt = 0;
		for(var i = 0; i < chk.length; i++){ /* 같은이름의 태그가 여러개 있으면 배열이 된다 ==> 그리고 배열.length 는 배열이 몇개있는지를 의미한다    */
			if(chk[i].checked == true){
				prodTot += Number(hddchk[i].value);
				cnt ++;
			}
		}
		document.getElementById("totalPrice").innerHTML=String(prodTot);
		document.getElementById("prodCnt").innerHTML=cnt;
	}
</script>
</head>
<body>
	&nbsp;&nbsp;&nbsp; 당신의 장바구니
	<form action="goodsBuy.gd" method="post"><!-- get으로 바꿔서 어떤값이 날라가는지 확인할수있다  -->
		<%-- <% int price=0 %> 와 같음 --%>
		<c:set var="price" value="0"></c:set>  <!--자바 변수를 선언해 주는것  (밖에다가 선언 안에하면 계속 0으로 초기화됨)-->
		<c:set var="cnt" value="0"></c:set>
		<c:forEach items="${lists }" var="dto">
			<table border=1 width =600 align="center">
				<tr>
					<td colspan="4">
					<input type="checkbox" value="${dto.productDTO.prodNum}" name="prodCk" onchange="prodChk();" checked>
					<input type="hidden" name="cartPrice" value="dto.cartDTO.cartPrice + dto.productDTO.prodDelFee}">
					${dto.productDTO.prodSupplyer }</td>
					<td>배송비</td>
					<td>총 적용금액</td>
					<td rowspan="2"><input type="button" value="삭제" onclick="javascript:location.href='cartProdDel.gd?prodNum=${dto.productDTO.prodNum }';"></td><!--초록색 js는 공백을 주면 안되고 흰색 자바는 공백을 줘도 상관없다  -->
				</tr>
				<tr>
					<td><img src="goods/upload/${dto.productDTO.prodImage.split(',')[0] }"  width="50"/></td>
					<td>${dto.productDTO.prodName }</td>
				     <!-- 자바스크립트를 사용해야 마이너스에 0이 아니게 만들수있어요~ -->
				    <td align="center"><a href="javascript:checkQty('${dto.productDTO.prodNum }','${dto.productDTO.prodPrice }','${dto.cartDTO.cartQty }')">-</a>
				    	 &nbsp;&nbsp; ${dto.cartDTO.cartQty }&nbsp;&nbsp;
				     	<a href="goodsCartAdd.gd?prodNum=${dto.productDTO.prodNum }&qty=1&&prodPrice=${dto.productDTO.prodPrice }"> +</a></td>
				    <td>${dto.cartDTO.cartPrice }</td>
				    <td>${dto.productDTO.prodDelFee }</td>
				    <td>${dto.cartDTO.cartPrice + dto.productDTO.prodDelFee}</td>			    
				</tr>
				
			</table>
			<c:set var="cnt" value="${cnt = cnt + 1 }"></c:set>
			<c:set var="price" value="${dto.cartDTO.cartPrice + dto.productDTO.prodDelFee + price }"></c:set>
		</c:forEach>
		<span id="prodCnt">${cnt }</span> 명의 선수가 선택되었습니다. <br>
		총금액 : <span id="totalPrice">${price }</span>
		<input type="submit" value="구매하기">
	</form>
</body>
</html>