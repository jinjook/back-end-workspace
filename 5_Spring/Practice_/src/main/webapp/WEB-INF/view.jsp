<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<h1>게시물 정보</h1>
		<form action="/update" method="post" >
		<input type="hidden" name="no" value="${bo.no}">
			<div class="form-group">
				<label>Title</label>
				<input class="form-control" type="text" name="title" value="${bo.title}">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" name="content" rows="10">${bo.content}</textarea>
			</div>
			
			<a class="btn btn-outline-warning" href="/">목록</a>
			<button type="submit" class="btn btn-outline-warning">수정</button>
			<a href="/delete?no=${bo.no}" class="btn btn-outline-danger">삭제</a>
		</form>
	</div>
</body>
</html>