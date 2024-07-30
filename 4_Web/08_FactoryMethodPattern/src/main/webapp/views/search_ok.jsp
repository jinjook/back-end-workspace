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
	 <ul>
	 	<li>아이디 : ${search.id}</li>
	 	<li>비밀번호 : ${search.pwd}</li>
	 	<li>이름 : ${search.name}</li>
	 </ul>
	 <a href="/">메인 페이지로 이동</a><br>
</body>
</html>