<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] arr = {"두루치기", "삼계탕", "김치찌개", "삼겹살", "순두부찌개"};
	%>
	
	<!-- for(String menu : arr) 향상된 for문 
	 	이거에 관한 설명은 MemberJSTL allMember.jsp에서 확인
	-->
	<c:forEach items="${arr}" var = "menu">
		- ${menu}<br>
	</c:forEach>
</body>
</html>