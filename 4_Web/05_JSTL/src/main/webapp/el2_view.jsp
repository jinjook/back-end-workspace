<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1) 기존 방식</h2>
	<%=request.getParameter("id") %><br>
	<% String[]	hobbyList = request.getParameterValues("hobby");
		for(String hobby : hobbyList){ %>		
		- <%= hobby %><br>
	<% } %>
	
	<h2>2) EL 방식</h2>
	${param.id}<br>
	- ${paramValues.hobby[0]}<br>
	- ${paramValues.hobby[1]}
	<!-- EL로는 반복문/조건문 불가, 하나하나 기재해야함 -->
</body>
</html>