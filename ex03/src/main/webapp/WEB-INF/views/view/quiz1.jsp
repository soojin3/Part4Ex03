<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button>나를 눌러봐</button><br>
	<span></span>
	
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
		
		<script type="text/javascript">	
		$("button").on("click",function(){
			console.log("확인 나를 눌러봐");//aa자바 스크립트 객체
			$.ajax({
				type:"get",
				url:"/quiz/quiz1",	//응답 hi~ 텍스트
				//data 보내는거 없음
				dataType:"text",
				//contentType 보내는거 없음
				success: function(mydata){ //받아온 데이터
					console.log("받아온 데이터 ",mydata);
					$("span").append(mydata);
					
				}
			})
		});
		
		
		
		</script>
</body>
</html>