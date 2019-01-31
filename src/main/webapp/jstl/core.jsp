<%@page import="kr.or.ddit.rangers.model.RangerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	jstl을 사용하기 위한 준비 : jsp 디렉티브(taglib)를 이용하여 사용하고자 하는 라이브러리 선언
						    prefix = "임의로 작성 가능하나 일반적으로 사용하는 이름 권장"
						              core : c, format : fmt, function : fn
						    uri  = "자동완성기능으로 작성"
	
 --%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>core : set</h2>
	<!-- 
		특정 scope(page, requset, session, application)에 속성을 생성
		기본 scope : page
	-->
	
	<!-- 
		pageContext.setAttribute("userId", "brown");
		session.setAttribute("userId", "brown");
	 -->
	<c:set var="userId" value="brown" scope="session"/>
	userId(표현식-page) : <%=pageContext.getAttribute("userId") %> <br>
	userId(표현식-session) : <%=session.getAttribute("userId") %> <br>
	userId(EL) : ${userId} <br>
	
	<%
		RangerVO rangerVO = new RangerVO("brown", "브라운", 8);
		session.setAttribute("ranger", rangerVO);
	%>
	<c:set target="${ranger}" property="age" value="5"/>
	ranger - 나이변경 : ${ranger} <br>
	
	<!-- localhost/jstl/core.jsp -->
</body>
</html>