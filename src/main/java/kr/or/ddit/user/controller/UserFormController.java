package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IUserService userService; 
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	/**
	 * Method : doGet
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 사용자 등록 폼
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}

	/**
	 * Method : doPost
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 사용자 정보 등록
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//1.사용자 아이디 중복체크
		//2-1.중복체크 통과 : 사용자 정보를 db에 입력
		//2-1-1.사용자 페이징 리스트 1 페이지로 이동
		String userId = request.getParameter("userId");
		UserVO duplicateUserVO = userService.selectUser(userId);
		
		if(duplicateUserVO == null){
			String userNm = request.getParameter("userNm");
			String alias = request.getParameter("alias");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String zipcode = request.getParameter("zipcode");
			String pass = request.getParameter("pass");
			
			duplicateUserVO = new UserVO(userId, userNm, alias, addr1, addr2, zipcode, pass);
			int result = userService.insertUser(duplicateUserVO);
			
			//정상입력(성공)
			if(result == 1){
				//db에서 데이터를 조작하는 로직을 처리할때는 forward가 아니라 redirect를 사용해야함(새로고침시 최초요청 url로 다시 이동하기때문에)
				//redirect는 ContextPath를 써줘야하며 redirect는 get방식임
				//request.getRequestDispatcher("/userPagingList").forward(request, response);
				request.getSession().setAttribute("msg", "정상 등록 되었습니다.");
				response.sendRedirect(request.getContextPath() + "/userPagingList");
			}
			//정상입력(실패)
			else{
				doGet(request, response);
			}
		}
		//2-2.중복체크 통과 실패 : 사용자 등록페이지로 이동
		else{
			//forward 시에는 최초 요청한 method를 변경불가
			//post --> post
			//request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
			request.setAttribute("msg", "중복체크에 실패했습니다!");
			doGet(request, response);
		}
	}

}