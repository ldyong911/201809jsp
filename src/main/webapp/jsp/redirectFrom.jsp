<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//클라이언트에게 다른 주소로 요청(redirect)하라고 지시
	response.sendRedirect("/jsp/redirectTo.jsp");

	//최초 요청 : localhost/jsp/redirectFrom.jsp
	//			redirectFrom.jsp 요청 수락
	//			redirect 지시 : /jsp/redirectTo.jsp
	//최초 응답 : 서버의 redirect지시 접수
	//두번째 요청: localhost/jsp/redirectTo.jsp
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