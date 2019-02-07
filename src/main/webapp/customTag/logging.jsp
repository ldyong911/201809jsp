<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>loggings.tag</h2>
	logging.jsp 출력 <br>
	<tags:loggings/>
	logging.jsp 출력 <br>
	<tags:loggings/>
	
	<h2>colorLogging.tag</h2>
	<tags:colorLogging color="red" size="20"/>
	<tags:colorLogging color="orange" size="30"/>
	<tags:colorLogging color="blue" size="40"/>
</body>
</html>