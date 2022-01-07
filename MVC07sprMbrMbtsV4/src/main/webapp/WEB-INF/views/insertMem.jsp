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
		<h2>회원가입</h2>
		<form action="insertUser" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="100" align="center">아이디</td>
					<td><input name="id" type="text" /></td>
				</tr>
				<tr>
					<td bgcolor="orange" align="center">암호</td>
					<td><input name="pw" type="password" /></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="100" align="center">이름</td>
					<td><input name="name" type="text" /></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70" align="center">연락처</td>
					<td><input name="tel" type="text" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="회원가입 완료"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>