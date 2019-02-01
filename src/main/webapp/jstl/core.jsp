<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.ddit.rangers.service.RangersService"%>
<%@page import="kr.or.ddit.rangers.model.RangerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	jstl을 사용하기 위한 준비 : jsp 디렉티브(taglib)를 이용하여 사용하고자 하는 라이브러리 선언
						    prefix = "임의로 작성 가능하나 일반적으로 사용하는 이름 권장"
						              core : c, format : fmt, function : fn
						    uri  = "자동완성기능으로 작성"
	
 --%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>core - set</h2>
	<!-- 
		특정 scope(page, requset, session, application)에 속성을 생성
		기본 scope : page
	-->
	<!-- 
		var : 값을 설정할 EL변수의 이름
		value : 변수의 값을 설정(표현식, EL, 상수 사용 가능)
		scope : 변수가 저장되는 영역 설정(page|request|session|application 생략가능, 생략시 기본값은 page)
	 -->
	 <!-- 
		pageContext.setAttribute("userId", "brown");
		session.setAttribute("userId", "brown");
	 -->
	<c:set var="userId" value="brown" scope="session"/>
	userId(표현식-page) : <%=pageContext.getAttribute("userId") %> <br>
	userId(표현식-session) : <%=session.getAttribute("userId") %> <br>
	userId(EL) : ${userId} <br>
	
	<%
		RangerVO rangerVO = new RangerVO("brown", "브라운", 8);
		session.setAttribute("ranger", rangerVO);
	%>
	<!-- 
		target : 속성값을 설정할 대상 bean객체 or Map객체(표현식, EL변수 사용가능)
		property : 설정할 bean객체의 멤버변수 이름(setter가 있는) or Map객체의 key 이름
		value : 속성값
	 -->
	<c:set target="${ranger}" property="age" value="5"/>
	ranger - 나이변경 : ${ranger} <br>
	
	<!-- 
		pageContext.setAttribute("test", new RangerVO("brown", "브라운", 15));
	 -->
	<h2>객체생성</h2>
	<c:set var="test" value="<%=new RangerVO(\"brown\", \"브라운\", 15)%>" />
	<c:set var="test2" value="${RangerVO('brown', '브라운', '15')}"/>
	test : ${test} <br>
	test2 : ${test2} <br>
	
	<h2>속성삭제</h2>
	<c:remove var="test" />
	test : ${test} <br>
	
	<h2>core - if</h2>
	<!-- pageContext에 code 속성 추가 -->
	<c:set var="code" value="01"/>
	
	<!-- if는 단일처리 -->
	<c:if test="${code == '00'}">
		<span>code가 00 값입니다.</span>
	</c:if>
	
	<c:if test="${code == '01'}">
		<span>code가 01 값입니다.</span>
	</c:if>
	
	<h2>core - choose</h2>
	<!-- request.setAttribute("code", "03"); -->
	<c:remove var="code"/> <!-- page영역의 속성이름과 같아 영향받는것 제거 -->
	<c:set var="code" value="03" scope="request" />
	
	<!-- choose는 다중처리 -->
	<c:choose>
		<c:when test="${code == '00'}"> code가 ${code} 00 입니다. </c:when>
		<c:when test="${code == '01'}"> code가 ${code} 01 입니다. </c:when>
		<c:when test="${code == '02'}"> code가 ${code} 02 입니다. </c:when>
		<c:when test="${code == '03'}"> code가 ${code} 03 입니다. </c:when>
		<c:when test="${code == '04'}"> code가 ${code} 04 입니다. </c:when>
		<c:otherwise>code가 ${code} else 입니다.</c:otherwise> <%-- if에서 else에 해당하는 구문 --%>
	</c:choose>
	
	<h2>core - forEach</h2>
	<%
		RangersService rangersService = new RangersService();
		request.setAttribute("rangersList", rangersService.getAllRangerVO());
	%>
	
	<h3>향상 for문</h3>
	<c:forEach items="${rangersList}" var="ranger">
		${ranger.name} / ${ranger.alias} / ${ranger.age} <br>
	</c:forEach>
	
	<h3>일반 for문</h3>
	<c:forEach begin="0" end="${rangersList.size()-1}" var="i">
		${rangersList.get(i).name} / ${rangersList.get(i).alias} / ${rangersList.get(i).age} <br>
	</c:forEach>
	
	<h3>일반 for문</h3>
	<!-- for(int i=0; i<=5; i++) -->
	<!-- varStatus는 반복되는동안 사용되는 여러가지 값을 의미함, step은 증가값을 의미함 -->
	<c:forEach begin="0" end="15" varStatus="status" step="3">
		<span>test ${status.index}</span>
	</c:forEach>
	
	<h2>core - forEach (map)</h2>
	<%
		Map<String, String> map = new HashMap<String, String>();
		map.put("ranger1", "brown");
		map.put("ranger2", "cony");
		map.put("ranger3", "sally");
		pageContext.setAttribute("map", map);
	%>
	<c:forEach items="${map}" var="entry">
		${entry} <br>
		${entry.key} / ${entry.value} <br>
	</c:forEach>
		
	<!-- localhost/jstl/core.jsp -->
</body>
</html>