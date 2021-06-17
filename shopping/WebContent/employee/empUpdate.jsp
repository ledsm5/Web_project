<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="empModify.jsp" >
		<table border =1>
			<tr><td>사원번호: </td><td> <input type="text" name="employeeId" value ="${dto.employeeId }"></td></tr> 
			<tr><td>아이디: </td><td> <input type="text" name="empName" value ="${dto.empName }"></td></tr>
			<tr><td>이름: </td><td><input type="text" name="hireDate" value ="${dto.hireDate }"></td></tr>
			<tr><td>직무: </td><td> <input type="text" name="jobId" value ="${dto.jobId }"></td></tr>
			<tr><td>연락처: </td><td> <input type="text" name="phNumber" value ="${dto.phNumber }"></td></tr>
			<tr><td>이메일: </td><td> <input type="text" name="email" value ="${dto.email }"></td></tr>
			<tr><td>주소: </td><td> <input type="text" name="empAddress" value ="${dto.empAddress }"></td></tr>
			<tr>
				<td>
					<input type="button" value ="수정">
					<input type="button" value ="이전" onclick="javascript:history.back();">
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>