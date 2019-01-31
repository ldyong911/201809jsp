<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>cookies</h3>
	<%
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies){
			out.write("cookieName : " + cookie.getName() + " / cookieValue = " + cookie.getValue() + "<br>");
			
		}
		
		// 1. 웹브라우저에서 주소줄에 : localhost/cookieList
		// 2. /cookieList url을 처리하는 CookieServlet
		// 3. 웹 브라우저의 주소줄로 요청을 보냈기 때문에 get 요청이 되고
		// 4. cookieServlet의 doGet()가 실행
		// 5. request.getRequestDispatcher("/jsp/cookieList.jsp").forward(request, response);
	%>
	
	<h3>session</h3>
	session.getId() : <%=session.getId() %> <!-- JSESSIONID와 값이 같음 -->
	
	<h3>서버 사이드 cookie 생성</h3>
	<%
		Cookie newCookie = new Cookie("serverSideCookie", "serverSideValue");
		
		//setMaxAge는 초단위 값을 인자로 받는다
		//5일 : 5 * 24(hour) * 60(minute) * 60(second)
		newCookie.setMaxAge(5*24*60*60);
		
		response.addCookie(newCookie);
	%>
	
</body>
</html>