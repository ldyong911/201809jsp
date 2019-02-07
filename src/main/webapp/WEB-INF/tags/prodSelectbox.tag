<%@tag import="java.sql.PreparedStatement"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@tag import="java.sql.SQLException"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="prod_lgu" type="java.lang.String" required="true" %>

<%
	String prod_lgu = (String)jspContext.getAttribute("prod_lgu");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BasicDataSource bds = null;

	try {
		// connection pool 준비
		bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("pc_11");
		bds.setPassword("java");
		bds.setInitialSize(5);

		conn = bds.getConnection();

		pstmt = conn.prepareStatement("select prod_id, prod_name from prod where prod_lgu=?");
		pstmt.setString(1, prod_lgu);

		rs = pstmt.executeQuery();
		
		out.write("<select>");
		while (rs.next()) {
			out.write("<option value='"+rs.getString("prod_id")+"'>");
			out.write(rs.getString("prod_name"));
			out.write("</option>");
		}
		out.write("</select>");

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if(rs != null) try {rs.close();} catch (SQLException e2) {e2.printStackTrace();}
		if(pstmt != null) try {pstmt.close();} catch (SQLException e2) {e2.printStackTrace();}			
		if(conn != null) try {conn.close();} catch (SQLException e2) {e2.printStackTrace();}
	}
	bds.close();
%>