let idSubmit = false;
let pwdSubmit = false;
id.addEventListener("input", function(e){
	// 영어 숫자로만 10-14글자, 시작은 영어로 -> 정규표현식 사용
	const regExp = /^[a-zA-Z][a-zA-Z0-9]{9,13}$/;
	
	// 중복체크
	$.ajax({
		type: 'post',
		url: '/check',
		data: {
			id: e.target.value
		},
		
		success: function(data){ // data가 boolean으로 오는 중
			if(data){
				// 정보가 있을 때 -> 중복된 아이디
				idCheck.innerHTML = "중복된 아이디입니다. 다시 입력해주세요";
				idCheck.style.color = "indianred";
				idSubmit=false;
			} else {
				if(regExp.test(e.target.value)){
					idCheck.style.color ="green";
					idCheck.innerHTML = "OK";
					idSubmit = true;
				} else if (e.target.value === "") {
					idCheck.innerHTML = ""; //비어있으면 안되고
					idSubmit=false;
				} else {
					idCheck.style.color="indianred";
					idCheck.innerHTML="첫글자는 영문, 영문 또는 숫자로만 10~14글자";
					idSubmit = false;
				}
			}
		}
	});
});

password.addEventListener("input", function(e) {
	// 특수문자, 대문자, 소문자 하나씩 전부 하나 이상 포함
	const regExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!*]).*$/;
	if(regExp.test(e.target.value)){
		pwdCheck.innerHTML ="OK"
		pwdCheck.style.color ="green"
		pwdSubmit = true;
	} else if(e.target.value === ""){
		pwdCheck.innerHTML ="";
		pwdSubmit = false;
	} else {
		pwdCheck.innerHTML="특수문자, 대문자, 소문자, 숫자 한 개 이상 무조건 포함";
		pwdCheck.style.color ="indianred";
		pwdSubmit = false;
	}
});


function validate(){ // return이 true일때만 전송 되도록 해줌
	if(!idSubmit) id.focus();
	else if(!pwdSubmit) password.focus();
	return idSubmit && pwdSubmit;
}