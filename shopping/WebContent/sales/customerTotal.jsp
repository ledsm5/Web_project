<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	   <script type="text/javascript">
	      google.charts.load('current', {'packages':['corechart']});
	      google.charts.setOnLoadCallback(drawVisualization);
	   
	      function drawVisualization() { 
	         var data = google.visualization.arrayToDataTable(${googleList});
	              
	         var options = {
	               title : '고객별 판매 현황',
	               vAxis: {title: '금액 및 수량'},
	               hAxis: {title: '사용자'}, 
	               seriesType: 'bars',
	               series: {5: {type: 'line'}}
	            };
	         
	         var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
	         chart.draw(data, options);
	      }
	   </script>
	
</head>
<body>
	<div id="chart_div" style="width:900px; height: 500px;"></div>
		고객별 현황 <br/>
	<table border="1">
    	<tr>
        	<td>이름/아이디</td> <td>총 구매금액</td> <td>횟수</td> <td>평균금액</td>
    	</tr>

    	<c:forEach items = "${list}" var="dto">
        <tr>
            <td>${dto.memName}/${dto.memId}</td>
            <td>${dto.sumPrice}</td> <td>${dto.count}</td> <td>${dto.avg}</td>
        </tr>
   		 </c:forEach>
	</table>
	
</body>
</html>