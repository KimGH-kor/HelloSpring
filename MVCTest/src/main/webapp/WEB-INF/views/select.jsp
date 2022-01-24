<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head><title>회원조회</title></head>
	<body>
<table border="1">
	<tr>
		<td width="40">코드</td>
		<td width="50">성명</td>
		<td width="80">목표체중</td>
	</tr>
	
	<c:forEach var="mbr" items="${LIST}">
		<tr>
			<td>${mbr.code }</td>
			<td>${mbr.name }</td>
			<td>${mbr.weight }</td>
		</tr>
	</c:forEach>
</table>
		건수 ${CNT}<br>
		평균체중 ${AVG}<br>
		
<a href="insert"><input type="button" value="회원등록"></a>

</body>
</html>