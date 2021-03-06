<%@page import="kr.or.ddit.lprod.model.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
	
  </head>

  <body>
  	<%@ include file="/module/header.jsp" %>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        	<%@ include file="/module/left.jsp" %> 
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Lprod 전체 리스트</h1>
          	<!-- userList 정보를 화면에 출력하는 로직 작성 -->
          	<div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>LPROD_ID</th>
                  <th>LPROD_GU</th>
                  <th>LPROD_NM</th>
                </tr>
              </thead>
              <tbody>
                <%
                	List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("lprodList");
    		
    				for(int i=0; i<lprodList.size(); i++){
    					//data-변수이름 을 통해 JQuery로 $(this).data("변수이름") 이렇게 값을 가져올 수 있음
    					//예)data-lprodgu를 통해 JQuery로 $(this).data("lprodgu") 이렇게 값을 가져올 수 있음
    					out.write("<tr class='lprodTr' data-lprodgu='" + lprodList.get(i).getLprod_gu() + "'>");
    					out.write("<td>"+lprodList.get(i).getLprod_id()+"</td>");
    					out.write("<td>"+lprodList.get(i).getLprod_gu()+"</td>");
    					out.write("<td>"+lprodList.get(i).getLprod_nm()+"</td>");
    					out.write("</tr>");
    				}
                %>
                
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	<script>
		//문서로딩이 완료된 이후 이벤트 등록
		$(document).ready(function(){
			console.log("document ready");
			
			//lprod tr 태그 클릭시 이벤트 핸들러
// 			$(".lprodTr").click(function(){
// 			});
			
			$(".lprodTr").on("click", function(){
				console.log("lprodTr click");
				//클릭한 userTr태그의 userId 값을 출력
// 				console.log($(this).children()[1].innerText);
// 				console.log("data-lprodgu : " + $(this).data("lprodgu"));
				
				var lprod_gu = $(this).data("lprodgu");
				
				// 1.document
// 				document.location = "/prodList?lprod_gu=" + lprod_gu;
				
				// 2.form
				$("#lprod_gu").val(lprod_gu);
// 				$("#frm").attr("action", "/prodList"); //속성바꿀때 사용
				$("#frm").submit();
				
			});
			
		});
	</script>
	<form id ="frm" action="<%=request.getContextPath()%>/prodList" method="get">
		<input type="hidden" id="lprod_gu" name="lprod_gu"/>
	</form>
  </body>
</html>