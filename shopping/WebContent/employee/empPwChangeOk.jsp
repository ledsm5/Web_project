<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			if($("#memPw")).val()==""){
			alert("현재 비밀번호를 입력하세요");
			$("#empPw").focus();
		}
		});
	});
</script>
</head>
<body>
	<form action="ChangePw.em" name="frm" method="post" id="frm">
		현재 비밀번호 : <input type="password" name="empPw" id="empPw" /><br /> 변경
		비밀번호 : <input type="password" name="newPw" id="newPw" /><br /> 변경
		비밀번호 확인:<input type="password" name="newPwCon" id="newPwCon" /><br />
		<input type="button" value="비밀변호 변경" id="btn" />
	</form>
</body>
</html>