<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- 어디로 전송할지? : form 태그 action -->
	<!-- 전송 메소드 : form 태그 method(default : get) -->
	<!-- 전송 파라미터 : input, select, textarea 태그의 name 속성이 존재 해야함 -->
	
	<!-- contextpath 경로가 변경될시 유동성을 위하여 request.getContextPath()로 받아오는게 좋음 -->
	<form action="<%=request.getContextPath() %>/login/loginRequest.jsp" method="post">
		아이디 : <input type="text" name="userId" value="호날두">
			    <input type="text" name="userId" value="메시"> <br>
		패스워드 : <input type="password" name="password" value="축구"> <br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>