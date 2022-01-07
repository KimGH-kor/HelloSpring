<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Member's Information</h1>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">아이디</td>
				<td align="left"><input name="id" type="text"
					value="${user.id}" /></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">암호</td>
				<td align="left"><input name="pw" type="text"
					value="${user.pw}" /></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">이름</td>
				<td align="left"><input name="name" type="text"
					value="${user.name}" /></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">연락처</td>
				<td align="left"><input name="tel" type="text"
					value="${user.tel}" /></td>
			</tr>
		</table>

		<a href="main.jsp">메인화면</a>
	</center>
</body>
</html>