<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("memberId");
	if("jsp123".equals(id)){
		response.sendRedirect("/Myjsp/ch05/ch0503index.jsp?memberId="+id);
	}else{
%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 실패</title>
</head>
<body>
아이디가 jsp123이 아닙니다.
</body>
</html>
<%
	}
%>
