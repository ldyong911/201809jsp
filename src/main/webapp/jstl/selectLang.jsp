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
	<!-- 
		select 변경(ko -> ja) -> 서버요청??
		1.select로 변경한 로케일이 설정된 selectLang.jsp가 화면에 출력되도록
		2.select box option태그가 요청한 로케일로 선택이 되도록 설정
		3.만약 로케일 파라미터가 없을경우 기본값은 ko
	 -->
	
	<%
		// localhost/jstl/selectLang.jsp ==> lang 파라미터 미존재
		// form (button -> select) ==> lang 파라미터 존재
		String lang = request.getParameter("lang");
		lang = lang == null ? "ko" : lang;
		pageContext.setAttribute("lang", lang);
	%>
	<form id="frm" action="${pageContext.servletContext.contextPath}/jstl/selectLang.jsp">
		<select id="langSelect" name="lang">
			<option value="ko" <c:if test="${lang == 'ko'}">selected</c:if> >한국어</option>
			<option value="ja" <c:if test="${lang == 'ja'}">selected</c:if> >日本語</option>
			<option value="en" <c:if test="${lang == 'en'}">selected</c:if> >english</option>
		</select>
	</form>
	
	<fmt:setLocale value="${lang}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/>
		<fmt:message key="visitor">
			<fmt:param value="brown"/>
		</fmt:message>
	</fmt:bundle>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#langSelect").on("change", function(){
				$("#frm").submit();
			});
		});
	</script>
</body>
</html>