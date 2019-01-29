package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * NowServlet.java
 *
 * @author pc11
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정자 수정내용
 * ------ ------------------------
 * pc11 최초 생성
 *
 * </pre>
 */
public class NowServlet extends HttpServlet{
	
	/**
	 * Method : doGet
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 :
	 */
	
	//doGet : http메소드중 get 메소드 요청을 처리
	//get : 1.웹 브라우저에서 주소줄에 입력 : get 요청
	//      2.<a> 태그 href 속성에 설정된 주소 : get 요청
	//post : 1. form tag안에 있는 input 태그중 type="submit"으로 되어있고 form 태그 action 속성이 post인경우
	//       2. javascript로 post 전송을 강제한 경우
	
	//doGet : get요청에 대해 처리해주는 메소드
	//servlet : 자바코드에 html 코드를 삽입하는 형태
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
//		pw.println("Now Servlet");
		
		pw.println("<!DOCTYPE html>                 ");
		pw.println("<html>                          ");
		pw.println("<head>                          ");
		pw.println("<meta charset=\"UTF-8\">        ");
		pw.println("<title>Insert title here</title>");
		pw.println("</head>                         ");
		pw.println("<body>                          ");
		pw.println("	현재시간 : " + new Date()		 );
		pw.println("</body>                         ");
		pw.println("</html>                         ");
		
		pw.flush();
		pw.close();
		
		// servlet : 정적인 형태를 갖는 리소스가 아님
		// html/index.html --> localhost/html/index.html
		// /src/main/java/kr/or/ddit/servlet/NowServlet.java
		// url - servlet mapping작업 필요
		// 1.web.xml
		// 2.annotation
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}