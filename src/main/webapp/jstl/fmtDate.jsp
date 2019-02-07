<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var="now" value="<%=new Date()%>"/>
	now : ${now} <br>
	
	<h2>date -> string</h2>
	<h3>한국 - ko</h3>
	<fmt:setLocale value="ko_kr"/>
	ko date : <fmt:formatDate value="${now}"/> <br>
	<!-- 보통은 pattern을 정의해서 사용 -->
	ko date pattern : <fmt:formatDate value="${now}" pattern="yyyy.MM.dd"/> <br>
	
	<h3>독일 - de</h3>
	<fmt:setLocale value="de_de"/>
	de date : <fmt:formatDate value="${now}"/> <br>
	
	<h2>string -> date</h2>
	parseDate : <fmt:parseDate value="2019-02-07 12:00" pattern="yyyy-MM-dd HH:mm"/> <br>
	
	<h2>timeZone</h2>
	<fmt:timeZone value="Asia/Shanghai">
		shanghai : <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm"/> <br>
	</fmt:timeZone>
	
	<h2>setTimeZone</h2>
	<fmt:setTimeZone value="US/Alaska" var="alaska"/>
	alaska : <fmt:formatDate value="${now}" timeZone="${alaska}" pattern="yyyy-MM-dd HH:mm"/> <br>
	
</body>
</html>