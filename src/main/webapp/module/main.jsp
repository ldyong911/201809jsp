<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<!-- jsp page로 lib 포함하는방법 -->
	<!-- 정적 include -->
	<%@ include file="/module/jsLib.jsp" %>
</head>
<body>
	<%@ include file="/module/header.jsp" %> <br>
	module/main.jsp <br>
	
	<%
// 		RequestDispatcher rd = request.getRequestDispatcher("/module/footer.jsp");
// 		rd.include(request, response);
	%>
	
	<jsp:include page="/module/footer.jsp"/>
</body>
</html>

<!-- localhost/module/main.jsp -->