<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="empModifyOk.em" method="get" name="frm">
<input type="hidden" name="employeeId" 
							value="${emp.employeeId }"/>
<table border = 1 align="center">
	<tr><td>사원번호</td>
		<td> ${emp.employeeId}</td></tr>
	<tr><td>사원아이디</td>
		<td>${emp.empUserid}</td></tr>
	<tr><td>이름</td>
		<td>${emp.empName}</td></tr>
	<tr><td>입사일</td>
		<td>${emp.hireDate}</td></tr>
	<tr><td>직무</td>
		<td>
		<input type="text" name="jobId" value="${emp.jobId }"/></td></tr>
	<tr><td>연락처</td>
		<td>
			<input type="text" name="phNumber" 
		  placeholder="010-1234-1234" value="${emp.phNumber }"/>
		</td></tr>
	<tr><td>사무실번호</td>
		<td>
			<input type="text" name="officeNumber" 
		  placeholder="02-1234-1234" value="${emp.officeNumber }"/>
		</td></tr>
	<tr><td>이메일</td>
		<td>
			<input type="text" name="email" value="${emp.email }"/>
		</td></tr>
	<tr><td>사무실 주소</td>
		<td>
			<input type="text" name="empAddress" 
				value="${emp.empAddress }"/>
		</td></tr>
	<tr><td colspan="2" align="center">
			<input type="submit" value="직원정보 수정" />
			<input type="button" value="직원 삭제" 
			onclick="javascript:location.href='empDelete.em?empId=${emp.employeeId }'"/>
		</td></tr>
</table>
</form>
</body>
</html>