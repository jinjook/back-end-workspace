<%@page import="model.vo.Member"%>
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
	<h1>회원 관리 기능</h1>
	<ul>
		<c:choose>
		<c:when test ="${empty login}">
		<!-- 로그인 되어 있지 않은 경우 -->
		<li><a href="/views/register.jsp">회원가입</a></li>
		<!-- 회원가입 : 아이디, 비밀번호, 이름 입력 받아서
					 register 로 호출, post 방식
					 RegisterServlet
					 index.jsp로 이동
		 -->
		<li><a href="/views/login.jsp">로그인</a></li>
		<!-- 로그인 : 아이디, 비밀번호 입력받아서 
					/login 호출, post 방식
					LoginServlet : 세션 데이터 바인딩 필수!
					index.jsp로 이동
		--> 
		</c:when>
		<c:otherwise> 
		<!-- 로그인 되어 있는 경우 -->
		<li><a href="/views/search.jsp">회원검색</a></li>
		<!-- 회원검색 : 검색할 아이디 입력받아서
					 /search 호출, get 방식
					 SearchServlet
					 성공하면 views/search_ok.jsp 해당 정보 출력
					 실패하면 views/search_fail.jsp "검색 실패했습니다" 출력
		 -->
		<li><a href="/front?command=allMember">전체회원보기</a></li>
		<!-- 전체회원보기 : views/allMember.jsp에 리스트 출력 -->
		
		<li><a href="/front?command=logout">로그아웃</a></li>
		<!-- 로그아웃 : 로그아웃 후 index.jsp로 이동 -->
		</c:otherwise>
		</c:choose> 
	</ul>
</body>
</html>