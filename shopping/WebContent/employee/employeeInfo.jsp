<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	사원번호 : ${emp.employeeId }<br />
	아이디: ${emp.empUserid }<br />
	이름 : ${emp.empName }<br />
	입사일: ${emp.hireDate }<br />
	직무 : ${emp.jobId }<br />
	연락처 : ${emp.phNumber }<br />
	사무실번호 : ${emp.officeNumber }<br />
	이메일: ${emp.email }<br />
	주소 : ${emp.empAddress }<br />
<a href="empModify.em?empId=${emp.employeeId }">수정</a> | 
<a href="empList.em" >리스트로 가기</a>  
</body>
</html>