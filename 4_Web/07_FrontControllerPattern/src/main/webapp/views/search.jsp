<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원검색</h1>
	<form action="/front">
		<input type="hidden" name="command" value="search">
		검색할 아이디 <input type="text" name="id">
		<input type="submit" value="검색">
	</form>
</body>
</html>