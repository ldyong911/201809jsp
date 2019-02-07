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
	<form id="frm" action="${pageContext.servletContext.contextPath}/selectLang">
		<select id="langSelect" name="lang">
			<option value="ko">한국어</option>
			<option value="ja">日本語</option>
			<option value="en">English</option>
		</select>
	</form>
	
	<fmt:setLocale value="${lang}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/>
		<fmt:message key="visitor">
			<fmt:param value="conny"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			//select box selected 적용
			$("#langSelect > option").attr("selected", false);
			$("#langSelect > option[value=${lang}]").attr("selected", true); //js에서 el를 사용할땐 ""안에 사용
			
			$("#langSelect").on("change", function(){
				$("#frm").submit();
			});
		});
	</script>
</body>
</html>