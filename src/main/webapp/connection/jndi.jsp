<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		// DB작업에 필요한 객체변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // 쿼리문이 select일 경우에 필요함
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracleDB");
			
			// 1. 드라이버 로딩
// 			Class.forName("oracle.jdbc.driver.OracleDriver"); // 실제로 드라이버가 사용되는게 아니라 여기에 존재하는지 확인하는것
			
			// 2. DB에 접속(Connection객체 생성)
// 			String url = "jdbc:oracle:thin:@localhost:1521/xe";
// 			String userId = "pc_11";
// 			String password = "java";
// 			conn = DriverManager.getConnection(url, userId, password);
			
			conn = ds.getConnection();
			
			// 3. Statement객체 생성 => Connection객체를 이용한다.
			stmt = conn.createStatement();
			
			// 4. SQL문을 Statement객체를 이용하여 실행하고 실행결과를 ResultSet객체에 저장한다.
			String sql = "select * from lprod"; // 실행할 SQL문
			rs = stmt.executeQuery(sql); // SQL문이 select일 경우에는 executeQuery()메서드를 사용하고
			                             // insert, update, delete일 경우는 executeUpdate()메서드를 사용함
			
			// 5. ResultSet객체에 저장되어 있는 자료를 반복문과 next()메서드를 이용하여 차례로 읽어와 처리한다.
			System.out.println("실행한 쿼리문: " + sql);
			System.out.println("===== 쿼리문 실행 결과 =====");
			
			// rs.next() => ResultSet객체의 데이터를 가리키는 포인터를 다음 레코드로 이동 시키고
			//              그 곳에 자료가 있으면 true, 없으면 false를 반환한다.
			while(rs.next()) {
				// 컬럼의 자료를 가져오는 방법
				// 방법1) rs.get자료형이름("컬럼명")
				// 방법2) rs.get자료형이름(컬럼번호) => 컬럼번호는 1부터 시작
				out.write("lprod_id: " + rs.getInt("lprod_id") + "<br>");
				out.write("lprod_gu: " + rs.getString("lprod_gu") + "<br>");
				out.write("lprod_nm: " + rs.getString("lprod_nm") + "<br>");
				out.write("=========================" + "<br>");
			}
			System.out.println("출력 끝...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 종료(사용했던 자원을 모두 반납한다.)
			if(rs != null) try {rs.close();} catch (SQLException e2) {e2.printStackTrace();}
			if(stmt != null) try {stmt.close();} catch (SQLException e2) {e2.printStackTrace();}			
			if(conn != null) try {conn.close();} catch (SQLException e2) {e2.printStackTrace();}
		}
		
		// localhost/connection/jdbc.jsp
	%>
</body>
</html>