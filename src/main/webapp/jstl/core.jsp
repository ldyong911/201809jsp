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
	<!-- 
		var : 값을 설정할 EL변수의 이름
		value : 변수의 값을 설정(표현식, EL, 상수 사용 가능)
		scope : 변수가 저장되는 영역 설정(page|request|session|application 생략가능, 생략시 기본값은 page)
	 -->
	<c:set var="userId" value="brown" scope="session"/>
	userId(표현식-page) : <%=pageContext.getAttribute("userId") %> <br>
	userId(표현식-session) : <%=session.getAttribute("userId") %> <br>
	userId(EL) : ${userId} <br>
	
	<%
		RangerVO rangerVO = new RangerVO("brown", "브라운", 8);
		session.setAttribute("ranger", rangerVO);
	%>
	<!-- 
		target : 속성값을 설정할 대상 bean객체 or Map객체(표현식, EL변수 사용가능)
		property : 설정할 bean객체의 멤버변수 이름(setter가 있는) or Map객체의 key 이름
		value : 속성값
	 -->
	<c:set target="${ranger}" property="age" value="5"/>
	ranger - 나이변경 : ${ranger} <br>
	
	<!-- localhost/jstl/core.jsp -->
</body>
</html>