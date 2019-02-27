package kr.or.ddit.template;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/velocity")
public class VelocityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 조회 / 입력
		List<String> rangers = new ArrayList<String>();
		rangers.add("ronaldo");
		rangers.add("messi");
		rangers.add("neymar");
		
		request.setAttribute("rangers", rangers);
		
		//forward / redirect
		request.getRequestDispatcher("/template/velocity.vm").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}