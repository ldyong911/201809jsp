<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>사용자 아이디</th>
			<th>사용자 이름</th>
		</tr>
		<c:forEach items="${userList}" var="userVO">
			<tr>
				<td>${userVO.userId}</td>
				<td>${userVO.userNm}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>