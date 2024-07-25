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
	<p>request : <%=request.getAttribute("result") %></p>
	<p>session : <%=session.getAttribute("result") %></p>
	
	<%--
		EL
		- Attribute에 바인딩 된 값을 찾아오는 로직을 태그로 바꾼 기술
		- 바인딩한 값을 ${값}로 사용
	 --%>
	 <h2>2) EL</h2>
	 <p>request : ${requestScope.result}</p>
	 <p>session : ${sessionScope.result}</p>
	 <p>${result}</p> 
	 <p>${result2}</p>
	 <!-- 똑같은 키값일 경우, 범위가 좁은 애로 출력 -> request -->
</body>
</html>