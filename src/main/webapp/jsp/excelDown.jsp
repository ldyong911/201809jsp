<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//jsp 기본 객체 : request, response 
	response.setHeader("Content-Disposition", "attachment; filename=excel.xls");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>사용자이름</td>
			<td>사용자아이디</td>
		</tr>
		<tr>
			<td>호날두</td>
			<td>ronaldo</td>
		</tr>
		<tr>
			<td>메시</td>
			<td>messi</td>
		</tr>
	</table>
</body>
</html>