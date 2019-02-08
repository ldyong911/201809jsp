<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>with unt_cd</h2>
	<form action="${pageContext.request.contextPath}/wrapper" method="post">
		<input type="text" name="userId" value="brown"/> <br>
		<input type="text" name="unt_cd" value="line"/> <br>
		<input type="submit" value="전송"/>
	</form>
	
	<h2>without unt_cd</h2>
	<form action="${pageContext.request.contextPath}/wrapper" method="post">
		<input type="text" name="userId" value="brown"/> <br>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>