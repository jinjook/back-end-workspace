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
	<!-- 만약 1이 들어오면 "1값이 들어왔습니다" 출력
		 그 외에는 "1값이 들어오지 않았습니다" 출력 -> if 만 존재, else 없음. 조건을 따로 걸어야함
		 <c:if test = "조건"></c:if>
	 -->
	 <c:if test="${param.number == '1'}">
	 	<h2>1값이 들어왔습니다</h2>
	 </c:if>
	 <c:if test="${param.number != '1'}">
	 	<h2>1값이 들어오지 않았습니다</h2>
	 </c:if>
</body>
</html>