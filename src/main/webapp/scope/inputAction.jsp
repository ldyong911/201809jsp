<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//input.jsp에서 보내온 파라미터를 받는다.
		String pageParam = request.getParameter("pageS");
		String requestParam = request.getParameter("requestS");
		String sessionParam = request.getParameter("sessionS");
		String applicationParam = request.getParameter("applicationS");
		
		//각 scope에 값을 설정한다
		// page - pageContext, request - request, session - session, application - application
		pageContext.setAttribute("page", pageParam + "_setAttr");
		request.setAttribute("request", requestParam + "_setAttr");
		session.setAttribute("session", sessionParam + "_setAttr");
		application.setAttribute("application", applicationParam + "_setAttr");
		
		//inputForward.jsp로 forward
		request.getRequestDispatcher("/scope/inputForward.jsp").forward(request, response);
		
	%>
</body>
</html>