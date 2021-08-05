<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 추가하기</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <%-- AJAX를 사용하려면 더 많은 함수가 있는 js를 포함해야 한다. --%>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<b>이름:</b>
		<div class="d-flex justify-content-start">
			<input type="text" class="form-control col-3" id="name"placeholder="이름을 입력하세요">
			<button type="button" class="btn btn-info" id="nameCheckBtn">중복 확인</button>
		</div>
		
		<div id="statusArea"></div>
		<button type="submit" class="btn btn-success mt-4">가입하기</button>
	</div>
	
	<script>
		$(document).ready(function(){
			// 중복 확인 버튼 클릭
			$('#nameCheckBtn').on('click', function(){
				// div 태그 안에 있는 모든 태그를 비운다.(초기화)
				let name = $('#name').val().trim();
				
				if(name==''){
					$('#statusArea').append("<small class=\"text-danger\">이름이 비어있습니다.</small>");
					return;
				}
				
				// 이름이 중복되는지 확인(DB에서 조회) -> AJAX 통신
				$.ajax({
					type:'get'
					, data: {'name':name}
					, url: '/lesson06/ex02/is_duplication'
					, success: function(data){
						if (data.is_duplication == true) {
							$('#nameStatusArea').append('<span class="text-danger">중복된 이름입니다.</span>');
						}
					}
					, error: function(e){
						alert("error:" + e)
					}
				});
			});
			// 회원 가입 버튼 클릭
			$('#joinBtn').on('click', function(e) {
				e.preventDefault(); // 바로 서브밋 되는 것 방지
				
				console.log($('#nameStatusArea').children().length);
				
				// 만약 nameStatusArea에 아무 자식노드(태그)가 없다면 서브밋을 한다.
				if ($('#nameStatusArea').children().length == 0) {
					alert("서브밋 가능");
				} else {
					alert("서브밋 불가");
				}
			});
		});
	</script>
</body>
</html>