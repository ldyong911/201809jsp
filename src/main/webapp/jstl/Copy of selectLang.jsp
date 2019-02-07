<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		if("${param.optionValue == null}" == "true"){ //초기값 ko 설정
			$("#mySelect").val("ko");
		}else{
			$("#mySelect").val("${param.optionValue}"); //select 선택옵션(핵심코드)
		}
		$("#mySelect").on("change", function(){
			var option = $("#mySelect").val(); //select 선택옵션 value 얻어오기
			$("#optionValue").val(option); //파라미터값 세팅
			$("form").submit();
		});
	});
</script>
</head>
<body>
	<!-- 
		select 변경(ko -> ja) -> 서버요청??
		1.select로 변경한 로케일이 설정된 selectLang.jsp가 화면에 출력되도록
		2.select box option태그가 요청한 로케일로 선택이 되도록 설정
		3.만약 로케일 파라미터가 없을경우 기본값은 ko
	 -->
	<select id="mySelect">
		<option value="ko">한국어</option>
		<option value="ja">日本語</option>
		<option value="en">english</option>
	</select>
	
	<fmt:setLocale value="${param.optionValue}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/>
		<fmt:message key="visitor">
			<fmt:param value="brown"/>
		</fmt:message>
	</fmt:bundle>
	
	<form action="${pageContext.servletContext.contextPath}/jstl/selectLang.jsp" method="get">
		<input type="hidden" id="optionValue" name="optionValue"/>
	</form>
</body>
</html>