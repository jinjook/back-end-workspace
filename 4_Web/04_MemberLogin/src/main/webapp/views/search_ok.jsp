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
	<h1>회원 검색 결과</h1>
	<% Member m = (Member) request.getAttribute("search"); %>
	<ul>
		<li>아이디 : <%=m.getId() %></li>
		<li>비밀번호 : <%=m.getPwd() %></li>
		<li>이름 : <%=m.getName() %></li>
	</ul>
</body>
</html>