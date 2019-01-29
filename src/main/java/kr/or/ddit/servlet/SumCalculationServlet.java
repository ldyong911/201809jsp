package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sumCalculation")
public class SumCalculationServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startParam = request.getParameter("start");
		String endParam = request.getParameter("end");
		
		int start = Integer.parseInt(startParam);
		int end = Integer.parseInt(endParam);
		
		int res = 0;
		for(int i = start; i<=end; i++){
			res += i;
		}
		
		request.getSession().setAttribute("sumResult", res);
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}
}