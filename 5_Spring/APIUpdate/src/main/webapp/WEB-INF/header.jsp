<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}css/calander.css" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}js/index.global.js"></script>
</head>
<body>
	<c:if test="${not empty user}">
	<header>
      <div class="addgroup">
        <button id="addgroup"><i class="fa-solid fa-plus"></i></button>
      </div>
      
          <div class="modalgroup">
        <button id="groupmake" class="addgroup2">
          <i class="fa-solid fa-plus"></i>
          <p>그룹 생성</p>
        </button>

        <button id="grouppart" class="addgroup2">
          <i class="fa-solid fa-plus"></i>
          <p>그룹 참가</p>
        </button>
      </div>
      
      <div class="mymodal">
       <button type="button" onclick="location.href='/logout'" id="logout">로그아웃</button>
      </div>
      
      <div class="group" id="group">
     	 </div>
     	 <div class="user">
        <i class="fa-regular fa-user"></i>
      </div>
      
	</header>
	
		<script src="https://kit.fontawesome.com/ef885bd654.js"
      		crossorigin="anonymous">
		</script>
		<script>
		<%--
			$("#addgroup").click(function () {
			  $("#modal1").css("display", "block");
			});
			  $(".close").click(function () {
			     $(".modal").css("display", "none");
			  });
			  $(window).click(function (event) {
			     if ($(event.target).is(".modal")) {
			       $(".modal").css("display", "none");
			     }
			  });
			$(document).keydown(function (event) {
			    if (event.keyCode == 27) {
			       $(".modal").css("display", "none");
			     }
			  });
			  --%>
    	</script>
    	
		<script>
		let buttonId;
		$(document).ready(function () {
			
		$.ajax ({
			type : "post",
			url : "/userGroup",
			success : function(list) {
				const groupList = list.map((item) => item.bigGroup);		
				const nameList = groupList.map((value) => value.groupName);				
				nameList.forEach((value) => {
					$("#group").append("<button type='button' class='groupButton' id='"+value+"'>"+"<i class='fa-solid fa-user-group'></i></button><span>"+value+"</span>");
				});
			}
		});
		
		
		});
		$(document).on('click', '.groupButton', function() {
	        buttonId = $(this).attr('id');
	        $.ajax({
	        	type:"post",
	        	url: "/selectGroup",
	        	data :{groupId: buttonId},
	        
	        	success: function(data){
	        		alert("!");
	        	}
	        });
	        console.log("버튼 클릭됨, ID:", buttonId);
	    });
		
		
		$("#add").click(() => {
			$.ajax({
				type : 'post',
				url : '/scheduleAdd',
				data : {info :$('#frm').serialize(),
						groupName : buttonId
						},
				success : function() {
					console.log('!');
				}
			
			});
		});
	</script>

	<script>
	$("#addNewGroup").click(() => {
		const title = $("#NewGroupName").val();
		console.log(title);
		$.ajax ({
			type : "post",
			url : "/addGroup",
			data : "groupName=" + title,
		// <button><i class="fa-solid fa-plus"></i></button>
			success : function(result) {
				console.log(result);
				if(result == true) {
					alert("생성완료!");
					$("#group").prepend("<button type='button' class='groupButton'><i class='fa-solid fa-user-group'></i></button><span>"+title+"</span>");
				} else {
					alert("사용할 수 없는 그룹명입니다.");
				}
			}
		});
	});
	</script>
	</c:if>
	<script src="${pageContext.request.contextPath}/js/calander.js"></script>
</body>
</html>
