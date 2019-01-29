package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1Param = request.getParameter("param1");
		String param2Param = request.getParameter("param2");
		
		int param1 = Integer.parseInt(param1Param);
		int param2 = Integer.parseInt(param2Param);
		
		int res = param1 * param2;
		
		request.getSession().setAttribute("mulResult", res);
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
	}
	
}