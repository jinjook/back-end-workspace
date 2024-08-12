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
	<c:choose>
	<c:when test="${not empty login}">
	<ul>
		<li><a href="/logout">로그아웃</a></li>
	</ul>
	<form action="/update" method="post">
		아이디 : <input type="text" name="id" value="${login.id}" readonly><br>
		비밀번호 : <input type="text" name="password" value="${login.password}"><br>
		이름: <input type="text" name="name" value="${login.name}"> <br>
		<input type="submit" value="수정">
	</form>
	<h2>비밀번호만 변경</h2>
	<form action="/update" method="post">
	<!-- <input type="hidden" name="id" value="${login.id}">
		-> client 에서 로그인한 아이디 보내서 처리하는 방법 -->
		비밀번호 : <input type="password" name="password"><br>
		<input type="submit" value="비밀번호 수정">
	</form>
	</c:when>
	<c:otherwise>
	<ul>
		<li><a href="/register">회원가입</a></li> <%-- controller로 이동 --%>
		<li><a href="/login">로그인</a></li>
	</ul>
	<form action="/search">
		<select name="select">
			<option value="all">이름 또는 아이디</option>
			<option value="id">아이디</option>
			<option value="name">이름</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<form action="/delete" method="post">
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${allMember!=null ? allMember : search}" var="m">
		<tr>	
			<td>${m.id}</td>
			<td>${m.password}</td>
			<td>${m.name}</td>
			<td><input type="checkbox" name="idList" value="${m.id}"></td>
		</tr>
		</c:forEach>
	</table>
	<input type="submit" value="삭제">
	</form>
	</c:otherwise>
	</c:choose>
</body>
</html>