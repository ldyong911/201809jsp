<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- jstl core taglib 추가 -->

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>스크립틀릿 / 표현식</h2>
	<%
		List<String> rangersList = (List<String>)request.getAttribute("rangersList");
	%>
	<table>
		<tr>
			<th>이름</th>
		</tr>
		<%-- 출력 --%>
		<%
			for(int i=0; i<rangersList.size(); i++){
				out.write("<tr>");
				out.write("<td>" + rangersList.get(i) + "</td>");
				out.write("</tr>");
			}
		%>
	</table>
	
	<h2>jstl / EL</h2>
	<table>
		<tr>
			<th>이름</th>
		</tr>
		<c:forEach items="${rangersList}" var="ranger">
			<tr>
				<td>${ranger}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>jstl / EL - vo</h2>
	<table>
		<tr>
			<th>이름</th>
			<th>별명</th>
			<th>나이</th>
		</tr>
		<c:forEach items="${rangersVOList}" var="ranger">
			<tr>
				<!-- ranger.name이면 name의 getName을 호출하며 el을 사용하기위해선 getter 필수 -->
				<td>${ranger.name} / ${ranger.getName()}</td>
				<td>${ranger.alias}</td>
				<td>${ranger.age}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>동일한 속성명</h2>
	userName(requset - 표현식) : <%=request.getAttribute("userName") %> <br>
	userName(EL-default) : ${userName} <br>
	userName(EL-request) : ${requestScope.userName} <br>
	userName(EL-session) : ${sessionScope.userName} <br>
	userName(EL-application) : ${applicationScope.userName} <br>
	
	<h2>EL 기본객체 param</h2>
	표현식 : <%=request.getParameter("p") %> <br>
	EL : ${param.p} <br> 
	
	<!-- localhost/rangersList -->
</body>
</html>