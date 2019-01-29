<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>out 객체</h2>
	<%
		out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>");
		out.write("application.getServletContextName() : " + application.getServletContextName() + "<br>");
		out.write("application.getContextPath() : " + application.getContextPath() + "<br>");
		out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
		out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");
	%>
	
	<h2>표현식</h2>
	application.getServerInfo() : <%=application.getServerInfo() %> <br>
	application.getServletContextName() : <%=application.getServletContextName() %> <br> 
	application.getContextPath() : <%=application.getContextPath() %> <br>
	application.getMajorVersion() : <%=application.getMajorVersion() %> <br>
	application.getMinorVersion() : <%=application.getMinorVersion() %> <br>
	
	<h2>초기화 파라미터</h2>
	ADMIN : <%=application.getInitParameter("ADMIN") %> <br>
	
	<h2>리소스 접근</h2>
	<%
		// webapp/main.jsp -> /main.jsp
		String path = "/main.jsp";
		InputStream is = application.getResourceAsStream(path);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		char[] buffer = new char[512];
		int len = 0;
		
		while((len = br.read(buffer, 0, buffer.length)) != -1){
			out.write(buffer);
		}
	%>
	
</body>
</html>