<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원 리스트 페이지입니다.<br />
<c:if test="${!empty empList }">
<table >
	<tr><td>사원번호</td><td>이름</td><td>직무</td><td>입사일</td><td>사무실번호</td></tr>
<c:forEach items="${empList }" var="dto">
	<tr>
		<td><a href="empInfo.em?empId=${dto.employeeId}">${dto.employeeId}</a></td>
		<td>${dto.empName}</td>
		<td>${dto.jobId}</td>
		<td>${dto.hireDate}</td>
		<td>${dto.officeNumber}</td>
	</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${empty empList }">
등록된 직원 없습니.
</c:if>
<a href="empRegest.em">직원등록</a>
</body>
</html>