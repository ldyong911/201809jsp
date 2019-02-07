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
	<!-- pageContext.setAttribute("num", 1000000); -->
	<c:set var="num" value="1000000"/>
	
	<h2>number -> formatted string</h2>
	<h3>한국 - ko</h3>
	<fmt:setLocale value="ko_kr"/> <!-- 국제화태그에서 나라코드는 oracle에서 참고 -->
	<!-- type : number, percent, currency -->
	ko number : <fmt:formatNumber value="${num}" type="number"></fmt:formatNumber> <br>
	ko percent : <fmt:formatNumber value="1" type="percent"></fmt:formatNumber> <br>
	ko currency : <fmt:formatNumber value="${num}" type="currency"></fmt:formatNumber> <br>

	<h3>독일 - de</h3>
	<fmt:setLocale value="de_de"/>
	de number : <fmt:formatNumber value="${num}" type="number"></fmt:formatNumber> <br>
	de percent : <fmt:formatNumber value="1" type="percent"></fmt:formatNumber> <br>
	de currency : <fmt:formatNumber value="${num}" type="currency"></fmt:formatNumber> <br>
	
	<!-- formatted string -> number : parsing -->
	<h2>formatted string -> number</h2>
	<fmt:setLocale value="ko_kr"/>
	parseNumber : <fmt:parseNumber value="1,000,000"></fmt:parseNumber>
	
</body>
</html>