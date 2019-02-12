<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/fileUpload"
		  method="post" enctype="multipart/form-data">
		<input type="text" name="userId" value="brown"/> <br>
		<input type="file" name="fileUpload"/> <br>
		<input type="submit" value="전송"/>	
	</form>
</body>
</html>