<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Member m = (Member) request.getAttribute("info"); 
	if(m != null) { %>	
	<h1>멤버 조회 결과</h1>
	<ul>
		<li> 아이디 : <%=m.getId() %></li>
		<li> 패스워드 : <%=m.getPwd() %></li>
		<li> 이름 : <%=m.getName() %></li>		
	</ul>
	<% } else { %>
	<h1>회원 정보가 없습니다</h1>
	<% } %>
</body>
</html>