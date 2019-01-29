<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 4개의 영역에서 속성을 조회 해본다 --%>
	pageContext : <%=pageContext.getAttribute("page") %> <br>
	request : <%=request.getAttribute("request") %> <br>
	session : <%=session.getAttribute("session") %> <br>
	application : <%=application.getAttribute("application") %> <br>
</body>
</html>