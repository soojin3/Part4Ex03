<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="number" id="num1">+
	<input type="number" id="num2">=
	<input type="number" id="sum">
	<br>
	<button id="button1">계산</button>
	<hr>
	<input type="number" id="mno"><br>
	<input type="text" id="firstName"><br>
	<input type="text" id="lastName"><br>
	<button id="button2">json 처리 확인</button>
	<span>home</span>
	
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
		
		
	<script type="text/javascript">
		$("#button1").on("click", function() {
			var num1 = $("#num1").val();
			var num2 = $("#num2").val();
			$.ajax({
				type : "get",
				url : "/sample/all/" + num1 + "/" + num2,
				success : function(data) {
					console.log("받아온 값", data);
					$("#sum").val(data);
				}
			})

		});
		
		$("#button2").on("click",function(){
			var aa={};//저바 스크립트 객체만드는 방법
			aa.mno=$("#mno").val();
			aa.firstName=$("#firstName").val();
			aa.lastName=$("#lastName").val();
			console.log("자바스크립트로 만든 객체",aa);//aa자바 스크립트 객체
			var jsondata=JSON.stringify(aa);//aa자바스크립트 객체를 제이선 포맷으로 바꿔줌
			console.log("제이선 포맷",jsondata);
			$.ajax({
				type:"post",
				url:"/sample/getSample",
				data: jsondata, //보내는 데이터
				dataType:"json",	//받아온 데이터 text,json,xml 생략시는 context
				contentType:"application/json; charset=utf-8", //전송데이터 형식
				success: function(data){ //받아온 데이터
					console.log("받아온 데이터 ",data);
					$("span").append(data);
					
				}
			})
		});
		
	</script>
</body>
</html>