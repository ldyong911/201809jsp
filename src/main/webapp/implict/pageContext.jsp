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
		//pageContext : 해당 jsp 페이지의 정보를 담고 있고 다른 기본 객체를 얻어 올 수 있다
		out.write("pageContext.getOut().equals(out) : " + pageContext.getOut().equals(out) + "<br>");
		out.write("pageContext.getRequest() : " + pageContext.getRequest() + "<br>");
		out.write("pageContext.getResponse() : " + pageContext.getResponse() + "<br>");
		out.write("pageContext.getSession() : " + pageContext.getSession() + "<br>");
		out.write("pageContext.getServletContext().equals(application) : " + pageContext.getServletContext().equals(application) + "<br>");
	%>
</body>
</html>