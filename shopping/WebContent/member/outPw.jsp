<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function outConfirm(){
		if(confirm("정말 왜그러세요? 탈퇴하시겠습니까")){
			document.frm.submit();
		}else{
			return false;
		}
	}
	
</script>
</head>
<body>
	<form action="memOutOk.mem" method="post" onsubmit="return outConfirm()" name="frm">
	비밀번호: <input type="password" name="memPw"><span>${pwFail }</span><br>
	<input type="submit" value="탈퇴">
	
	

	
	
	</form>
</body>
</html>