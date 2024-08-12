<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Ajax(Asynchronous JavaScript and XML : 비동기전 정보 교환 기법 -->
	<h1>Show Count</h1>
	<input type="button" id="btn" value="count 증가" onclick="startRequest()">
	<p id="result"></p>
	
	<!-- 자바스크립트 방식 -->
	<script>
	let xhr;
	
	function startRequest(){ // 요청에 해당하는 로직을 담는 메서드 (버튼 누르기)
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
			// 변화됐을때 어디로 
		//요청에 필요한것들
		xhr.open("get", "/count"); // get방식으로 /count로 보냄
		xhr.send(null); // 이때 서버로 전송됨 (실질적 요청)
	}
	
	function callback(){ // 응답에 해당하는 로직을 담는 메서드
		if(xhr.readyState === 4) {
			if(xhr.status === 200) {
				const count = xhr.responseText;
				document.querySelector("#result").innerHTML = count;
			}
		}
	}
	
	</script>
</body>
</html>