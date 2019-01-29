package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

@WebServlet("/userAllList")
public class UserAllListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IUserService userService;
		
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userService 사용자 전체 정보를 조회
		List<UserVO> userList = userService.getAllUser();
		
		//사용 전체 정보를 request 객체에 속성으로 설정
		request.setAttribute("userList", userList);
		
		// webapp/user/userList.jsp로 forward
		request.getRequestDispatcher("/user/userAllList.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}