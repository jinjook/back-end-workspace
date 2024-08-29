<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	<form id="frm"> <!-- action="/login" method="post" 는 ajax에 필요없음 -->
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="text" name="password"><br>
		<input type="submit" value="로그인" id="login">
	</form>
	
	<script>
		$('#login').click((e) => {
			//submit 하면 다음 페이지에 토큰이 그대로 노출 -> 막아버리기
			e.preventDefault(); // 기존 이벤트(submit) 제거
			$.ajax({
				url: "/login",
				type: "post",
				data: $('#frm').serialize(), // form id로 폼 전체 걸기
				
				success: function(data) {
					console.log(data); // 토큰 값 확인!
					
					// 토큰 값 -> localStorage 에 저장하기 (브라우저를 닫거나 강제로 삭제하지 않는이상 계속 남아있음)
					localStorage.setItem("token", data);
					location.href="/";
				}
			});
		});
	</script>
</body>
</html>