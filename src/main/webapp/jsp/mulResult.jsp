<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	곱하기 결과 : <%=session.getAttribute("mulResult") %> <br>
	곱하기 결과2 : <% out.write(session.getAttribute("mulResult").toString()); %>
</body>
</html>