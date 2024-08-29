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
	<jsp:include page="header.jsp"/>
	<input type="hidden" name="groupName" value="${bg.groupName}" />
	<div id="calendar-container">
      <div id="calendar"></div>
    </div>
   <h1>큰그룹 정보</h1>
   		<form action="/scheduleAdd" method="post">
			여행 이름 : <input type="text" id="tripName" name="tripName"><br/>
			시작 날짜 : <input type="text" id="startDate" name="startDate"><br/>
			종료 날짜 : <input type="text" id="endDate" name="endDate"><br/>
			총 경비 : <input type="text" id="totalMoney" name="totalMoney"><br/>
			<input type="submit" value="큰그룹정보" id="add">
			</form>
	<h1>작은그룹 정보</h1>
		<form action="/scheduleAdd2" method="post">
			메모 : <input type="text" name="memo" id="memo"><br/>
			종류 : <input type="text" name="items" id="items"><br/>
			예약여부 : <input type="text" name="isReservation" id="isReservation"><br/>
			<input type="submit" value="작은그룹" id="add2">
			</form>
   <div id="modal1" class="modal">
      <div class="modalcontent">
        <p class="close">&times</p>
        <h2>그룹 추가</h2>
        <hr />
        <br />
        <p>
          새로운 그룹에 이름을 부여해 <br />
          동료들과 함께해 보세요
        </p>
        <section class="mid">
          <h3>새 그룹 명</h3>
          <br />
          <input type="text" id="NewGroupName"/>
          <div class="add">
            <button id="addNewGroup" class="add2">만들기</button>
          </div>
        </section>
      </div>
    </div>

    <div id="modal2" class="modal">
      <div class="modalcontent">
        <p class="close">&times</p>
        <h2>그룹 참가</h2>
        <hr />
        <br />
        <p>
          아래에 전달받은 그룹코드를 입력해<br />
          그룹에 참여해보세요
        </p>
        <section class="mid">
          <h3>그룹 코드</h3>
          <br />
          <input type="text" placeholder="ex) Forever404" id="inputatt" />
          <div class="add">
            <button id="attend" class="add2">그룹 참가하기</button>
          </div>
        </section>
      </div>
    </div>
    </div>
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
		
		/*
		$("#add").click(() => {
			$.ajax({
				type : 'post',
				url : '/scheduleAdd',
				data : {tripName: $('#tripName').val(),
						groupName : buttonId
						},
				success : function() {
					console.log('!');
				}
			
			});
		});
		
		$("#add2").click(() => {
			$.ajax({
				type : 'post',
				url : '/scheduleAdd2',
				data : {sms: $('#frm2').serialize(),
						groupName: buttonId
						},
			success : function() {
			}
			})
		});
		*/
	</script>

	<script src="${pageContext.request.contextPath}/js/calander.js"></script>
</body>
</html>
