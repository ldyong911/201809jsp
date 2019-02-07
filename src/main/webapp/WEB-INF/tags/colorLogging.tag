<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- attribute는 jsp파일에서 속성을 받을때 사용 -->
<%@ attribute name="color" type="java.lang.String" required="false"%>
<%@ attribute name="size" type="java.lang.Integer" required="false"%>
<!-- size만큼 =을 출력한다 -->

<font color="${color}">
	<c:forEach begin="1" end="${size}">=</c:forEach> <br>
</font>