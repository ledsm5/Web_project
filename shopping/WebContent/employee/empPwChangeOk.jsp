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
			if($("#empPw").val()==""){
				alert("현재 비밀번호를 입력하세요");
				$("#empPw").focus();
				return false;
		  	}
			if($("#newPw").val()==""){
				alert("새로운 비밀번호를 입력하세요");
				$("#newPw").focus();
				return false;
			}
			if($("newPwCon").val()==""){
				alert("새로운 비밀번호를 확인해 주세요");
				$("#newPwCon").focus();
				return false;
			}else{
				if($("#newPw").val() != $("#newPwCon").val()){
					alert("비밀번호를 확인해주세요");
					$("#newPw").val() =="";
					$("#newPwCon").val() =="";
					$("#newPw").focus();				
				}
			}
			$("#frm").submit();
			
		});
	});
</script>
</head>
<body>
	<form action="changePw.em" name="frm" method="post" id="frm">
		현재 비밀번호 : <input type="password" name="empPw" id="empPw" /><br /> 변경
		비밀번호 : <input type="password" name="newPw" id="newPw" /><br /> 변경
		비밀번호 확인:<input type="password" name="newPwCon" id="newPwCon" /><br />
		<input type="button" value="비밀번호 변경" id="btn" />
		<input type="button" value="이전" onclick="javascript:history.back();">		
	</form>
</body>
</html>