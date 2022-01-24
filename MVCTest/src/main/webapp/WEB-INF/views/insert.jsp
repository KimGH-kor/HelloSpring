<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h4>회원등록</h4>

<form method="post" action="insertAction">
<table border="1">
	<tr>
		<td width="40">코드</td>
		<td width="50">성명</td>
		<td width="80">목표체중</td>
	</tr>
	<tr>
		<td><input type="text" name="code"></td>
		<td><input type="text" name="name"></td>
		<td><input type="text" name="weight"></td>
	</tr>
</table>
<input type="submit" value="등록">
<input type="reset" value="다시작성">
<a href="select"><input type="button" value="회원조회"></a>
</form>
</body>
</html>