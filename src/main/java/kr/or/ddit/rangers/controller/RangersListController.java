package kr.or.ddit.rangers.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.rangers.model.RangerVO;
import kr.or.ddit.rangers.service.RangersService;

@WebServlet("/rangersList")
public class RangersListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service 객체를 이용하여 rangerList를 조회
		RangersService rangersService = new RangersService();
		List<String> rangersList = rangersService.getAll();
		List<RangerVO> rangersVOList = rangersService.getAllRangerVO();
		
		//해당 데이터를 request 영역에 설정
		request.setAttribute("rangersList", rangersList);
//		request.setAttribute("rangersVOList", rangersVOList);
		request.getSession().setAttribute("rangersVOList", rangersVOList);
		
		//서로다른 영역에 같은 이름의 속성을 정의(같은 이름의 속성일 경우 page, request, session, application 순으로 차례대로 검색)
		//request attribute
		request.setAttribute("userName", "brown_request");
		
		//session attribute
		HttpSession session = request.getSession();
		session.setAttribute("userName", "brown_session");
//		session.removeAttribute("userName");
		
		//application attribute --> ServletContext
		ServletContext application = getServletContext();
		application.setAttribute("userName", "brown_application");
		
		// /rangers/rangersList.jsp로 forward
		// rangersList.jsp에서는 해당 데이터를 출력
		request.getRequestDispatcher("/rangers/rangersList.jsp").forward(request, response);
	}
}