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
		<form name="form2" action="insertAction" method="post">
			<table border="1">
				<tr>
					<td width="50">코드</td>
					<td width="100">성명</td>
					<td width="100">이메일</td>
					<td width="120">전화번호</td>
					<td width="70">체중</td>
				</tr>
				<tr>
					<td><input type="text" value="${CUST.code }" name="code"></td>
					<td><input type="text" value="${CUST.name }" name="name"></td>
					<td><input type="text" value="${CUST.email }" name="email"></td>
					<td><input type="text" value="${CUST.tel }" name="tel"></td>
					<td><input type="text" value="${CUST.weight }" name="weight"></td>
				</tr>
			</table>
			<input type="submit" value="회원등록"> <input type="reset"
				value="다시작성"> <a href="select?P_NUM=1"><input
				type="button" value="목록가기"></a>
		</form>
	</center>
</body>
</html>