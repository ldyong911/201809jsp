<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//header name을 담고 있는 enumeration
		Enumeration<String> headers = request.getHeaderNames();
	
		while(headers.hasMoreElements()){
			String headerName = headers.nextElement();
	%>
			headerName : <%=headerName %> : <%=request.getHeader(headerName) %><br>
	<%	} %>
</body>
</html>