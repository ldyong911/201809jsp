<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fmt - bundle</h2>
	<!-- local 임의 설정 -->
	<fmt:setLocale value="ko"/>
	<%
		session.setAttribute("userId", "brown");
	%>
	<!-- msg, msg_ko, msg_en, msg_ja : msg -->
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/> <br>
		<fmt:message key="visitor">
			<fmt:param value="${userId}"/>
		</fmt:message> <br>
	</fmt:bundle>
	
	<!-- local 임의 설정 -->
	<fmt:setLocale value="ja"/>
	<!-- msg, msg_ko, msg_en, msg_ja : msg -->
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/> <br>
		<fmt:message key="visitor">
			<fmt:param value="${userId}"/>
		</fmt:message> <br>
	</fmt:bundle>
	
	<h2>fmt - setBundle</h2>
	<fmt:setLocale value="en"/>
	<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg_en" />
	<fmt:message bundle="${msg_en}" key="hello"/><br>
	<fmt:message bundle="${msg_en}" key="visitor">
		<fmt:param value="${userId}"/>
	</fmt:message>
	
</body>
</html>