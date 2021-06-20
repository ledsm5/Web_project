<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="empUpdateOk.em" method="post" name="frm"> 
		<table border =1>
			<tr><td>사원번호: </td><td>${dto.employeeId }</td></tr> 
			<tr><td>아이디: </td><td> <input type="text" name="empUserId" value ="${dto.empUserid }"></td></tr>
			<tr><td>비밀번호: </td><td> <input type="password" name="empPw" ><span>${pwFail }</span></td></tr>
			<tr><td>이름: </td><td>${dto.empName }</td></tr>
			<tr><td>직무: </td><td> <input type="text" name="jobId" value ="${dto.jobId }"></td></tr>
			<tr><td>연락처: </td><td> <input type="text" name="phNumber" value ="${dto.phNumber }"></td></tr>
			<tr><td>이메일: </td><td> <input type="text" name="email" value ="${dto.email }"></td></tr>
			<tr><td>주소: </td><td> <input type="text" name="empAddress" value ="${dto.empAddress }"></td></tr>
			<tr>
				<td>
					<input type="submit" value ="수정">
					<input type="button" value ="이전" onclick="javascript:history.back();">
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>