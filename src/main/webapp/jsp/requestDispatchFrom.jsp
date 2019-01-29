<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//dispatch 방식은 서버 내부에서 위임이 이루어진다
	
	//1. client가 localhost/jsp/requestDispatchFrom.jsp 요청
	//2. /jsp/requestDispatchTo.jsp로 요청 위임
	
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/requestDispatchTo.jsp");
	rd.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>