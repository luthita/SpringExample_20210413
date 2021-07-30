<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> 

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<form method="post" action="/lesson06/ex01/add_new_user" id="addForm">
			<b>이름:</b>
			<input type="text" class="form-control col-3" name="name" id="name"placeholder="이름을 입력해주세요" > <br>
			<b>생년월일:</b>
			<input type="text" class="form-control col-3" name="yyyymmdd" id="yyyymmdd"placeholder="yyyymmdd 형식"><br>
			<b>이메일 주소:</b>
			<input type="text" class="form-control col-3" name="email"id="email"placeholder="이메일을 입력하세요"><br>
			<b>자기소개:</b>
			<textarea name="introduce" class="form-control" rows="10" cols="20" id="introduce"></textarea><br>
			
			<input type="submit" id="addBtn" class="btn btn-primary" value="추가">
			 
			<a href="#" class="btn btn-success" id="aBtn">버튼모양a태그</a>
		</form>
	</div>
	<script>
		$(document).ready(function(){
			/* // (1) jQuery의 submit 기능 이용하기
			$('#addForm').on('submit', function(e){
				e.preventDefault();	// 기본으로 submit 동작하는 것을 막는다.
				
				// alert("추가 버튼 클릭");
				
				// validation check
				let name = $('input[name=name]').val().trim();
				if(name == ''){
					alert("이름을 입력해주세요.");
					return;
				}
				
				let yyyymmdd = $('input[name=yyyymmdd]').val().trim();
				if(yyyymmdd = ''){
					alert("생년월일을 입력해주세요.");
					return;
				}
				
				// 여기까지 도달하면 submit된다.
			});
		 */
			$('#aBtn').on('click', function(e){
				//e.preventDefault();	// 기본으로 페이지 상단으로 올라가는 것을 막는다.
			});
			
			// (2) jQuery의 AJAX 통신을 이용하기
			$('#addBtn').on('click', function(e){
				// AJAX
				// validation check
				let name = $('input[name=name]').val().trim();
				if(name == ''){
					alert("이름을 입력해주세요.");
					return;
				}
				
				let yyyymmdd = $('input[name=yyyymmdd]').val().trim();
				if(yyyymmdd = ''){
					alert("생년월일을 입력해주세요.");
					return;
				}
				
				if(isNaN(yyyymmdd)){
					alert("숫자만 입력하세요");
					return;
				}
				
				let email = $('input[name=email]').val().trim();
				
				let introduce = $('textarea[name=introduce]').val().trim();
				
				console.log("email : " + email);
				console.log("introduce : " + introduce);
				
				// AJAX: form태그와 상관없이 비동기로 별도 요청 (request)
				$.ajax({
					type: 'POST'
					, url: '/lesson06/ex01/add_new_user'
					, data: {'name':name, 'yyyymmdd':yyyymmdd, 'email':email, 'introduce':introduce}
					, success: function(data){
						// alert(data);
						// location.href ="/lesson06/ex01/get_user";
						location.reload(); // 새로고침
					}, complete: function(data){
						alert("완료");
					}, error: function(e){
						alert("error " + e);
					}
				});
			});
		});
	</script>
</body>
</html>