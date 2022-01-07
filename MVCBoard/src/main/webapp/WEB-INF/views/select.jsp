<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>고객정보 보기 PAGE_NO=${P_NUM }</h2>

		<table border="1">
			<tr>
				<td width="50">코드</td>
				<td width="100">성명</td>
				<td width="250">이메일</td>
				<td width="120">전화번호</td>
				<td width="70">체중</td>
				<td width="100">비고</td>
			</tr>

			<c:forEach var="cust" items="${C_LIST }">
				<tr>
					<td>${cust.code }</td>
					<td>${cust.name }</td>
					<td>${cust.email }</td>
					<td>${cust.tel }</td>
					<td>${cust.weight }</td>
					<td><a href="update?CODE=${cust.code }">수정</a> <a
						href="delete?CODE=${cust.code }">삭제</a></td>
				</tr>
			</c:forEach>

		</table>


		<c:forEach var="i" begin="1" end="${NEXT_NUM}" step="1"
			varStatus="stat">
			<a href="select?P_NUM=${stat.index}"><c:out value="${stat.index}" /></a>
		</c:forEach>
		<br>
		<a href="insert"><input type="button" value="회원등록"></a>
	</center>
</body>
</html>