<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "empModifyOk.em" method ="post" name="frm">
	<input type = "hidden" name= "employeeId" value="${emp.employeeId }">
		<table border=1>
			<tr>
				<td>직원번호</td>
				<td><input type ="text" name="employeeId" value="${emp.employeeId }"></td>
			</tr>
			<tr>
				<td>직무 </td>
				<td><input type ="text" name="jobId" value="${emp.jobId }"></td>
			</tr>
			<tr>
				<td>핸드폰번호</td>
				<td><input type ="text" name="phNumber" value="${emp.phNumber }"></td>
			</tr>
			<tr>
				<td>사무실번호</td>
				<td><input type ="text" name="officeNumber" value="${emp.officeNumber }"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type ="text" name="email" value="${emp.email }"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type ="text" name="empAddress" value="${emp.empAddress }"></td>
			</tr>			
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