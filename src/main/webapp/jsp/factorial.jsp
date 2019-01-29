<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 1.factorial 메소드 로직 작성
	 2.jsp 스크립틀릿을 이용하여 1~8까지 factorial을 화면에 출력
 --%>

<%!
	public int factorial(int param){
		if(param < 0){
			return 0;
		}else if(param == 0){
			return 1;
		}else{
			return param * factorial(param-1);
		}
	}
%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Factorial 구하기!</h3> <br>
	<%
		for(int i=1; i<=8; i++){
	%>
			factorial : <%=i %>! : <%=factorial(i) %> <br>
	<%	} %>
</body>
</html>