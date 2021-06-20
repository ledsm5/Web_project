<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type ="text/javascript">
	function outConfirm(){
		if(confirm("정말 탈퇴하시겠습니까?")){
			document.frm.submit();
		}else {
			return false;
		}
	}
</script>
</head>
<body>
	회원탈퇴 페이지 
	<form action="empDropOutAction.em" method ="post" onsubmit="return outConfirm()" >
		비밀번호:
		<input type = "password" name="empPw">
		<span>${pwFail }</span><br>
		<input type ="submit" value="회원탈퇴" >
	</form>
</body>
</html>