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
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<form method="post" action="/lesson06/ex01/add_new_user">
			<b>이름:</b>
			<input type="text" class="form-control col-3" name="name" placeholder="이름을 입력해주세요" > <br>
			<b>생년월일:</b>
			<input type="text" class="form-control col-3" name="yyyymmdd" placeholder="yyyymmdd 형식"><br>
			<b>이메일 주소:</b>
			<input type="text" class="form-control col-3" name="email" placeholder="이메일을 입력하세요"><br>
			<b>자기소개:</b>
			<textarea name="introduce" class="form-control" rows="10" cols="20"></textarea><br>
			
			<input type="submit" id="addBtn" class="btn btn-primary" value="추가">
			 
		</form>
	</div>
</body>
</html>