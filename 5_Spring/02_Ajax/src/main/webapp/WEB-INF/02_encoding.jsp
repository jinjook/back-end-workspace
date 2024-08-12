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
	<h2>Encoding 처리하기</h2>
	닉네임 : <input type="text" id="nick">
	<input type="button" value="닉네임 보내기" id="btn"><!-- 자바스크립트에 필요 onclick="startRequest()" -->
	<div id="result"></div>
	
	<!-- 자바스크립트 방식 -->
	<!-- get 방식으로 / encoding <- 닉네임 보내서 요청
		해당 닉네임 받아서 result에 보여주기 -->

<!-- <script>
		let xhr;
	
		function startRequest(){
//			console.log(document.querySelector("#nick").value) : 닉값받기
			const nickname = document.querySelector("#nick").value
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback;
			xhr.open('get', '/encoding?nickname=' + encodeURI(encodeURIComponent(nickname))); // encoding 값을 get방식으로 보내기
			xhr.send(null);
		}
		
		function callback(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const result = xhr.responseText;
					// encoding -> decoding해줘야함
					document.querySelector("#result").innerText = decodeURI(decodeURIComponent(result));
				}
			}
		}
	</script>  -->	

	<script> /*jquery 사용*/
		$("#btn").click(() => {
			const nickname = $("#nick").val();
			$.ajax({
				// 요청
				type:"get", // get/post 방식 지정
				url: "/encoding",
				data: "nickname=" + encodeURIComponent(nickname), // 쉼표 중요! 끝난거 아님 - 연결중
								
				// 응답
				success: function(result){
					$("#result").text(result);
				}
			});
		});
	
	</script>

</body>
</html>