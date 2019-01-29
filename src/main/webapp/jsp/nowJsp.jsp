<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>    

<%-- jsp 주석 --%>
<%-- <%@ %> : 지시자(설정 정보) --%>
<%-- <%= %> : 표현식(출력시 사용) --%>
<%-- <%  %> : 스크립틀릿(자바코드를 사용하는 공간) --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp : html에 java 코드를 삽입하는 형태 -->
	<!-- localhost/jsp/nowJsp.jsp -->
	<h3>현재시간</h3>
	<%=new Date() %> <br>
	
	<% 
		String ranger = "brown";
		for(int i=0; i<5; i++){
	%>
			ranger : <%=ranger %> <br>
	<%	} %>
</body>
</html>