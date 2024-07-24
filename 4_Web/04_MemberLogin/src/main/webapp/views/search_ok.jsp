<%@page import="model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보</h1>
	<% Member m = (Member) request.getAttribute("search"); %>
	아이디 : <%=m.getId() %><br>
	비밀번호 : <%=m.getPwd() %><br>
	이름 : <%=m.getName() %>
</body>
</html>