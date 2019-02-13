package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

@WebServlet("/userModifyForm")
@MultipartConfig(maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)
public class UserModifyFormController extends HttpServlet {
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
	 * Method 설명 : 사용자 정보 조회
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserVO userVO = userService.selectUser(userId);
		
		request.setAttribute("userVO", userVO);
		
		request.getRequestDispatcher("/user/userModifyForm.jsp").forward(request, response);
	}

	/**
	 * Method : doPost
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 : 사용자 정보 수정
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userNm = request.getParameter("userNm");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass = request.getParameter("pass");
		
		UserVO userVO = new UserVO(userId, userNm, alias, addr1, addr2, zipcode, pass);
		
		//기존의 사진 가져오기
//		UserVO originUserVO = userService.selectUser(userId);
//		String filename = originUserVO.getFilename();
//		String realFilename = originUserVO.getRealFilename();
		String filename = "";
		String realFilename = "";
		
		//사진 수정
		Part profilePart = request.getPart("profile");
		
		if(profilePart.getSize() > 0){
			String contentDisposition = profilePart.getHeader("Content-Disposition");
			filename = PartUtil.getFileNameFromPart(contentDisposition);
			realFilename = "d:\\picture\\" + UUID.randomUUID().toString();
			
			profilePart.write(realFilename);
			profilePart.delete();
		}
		userVO.setFilename(filename);
		userVO.setRealFilename(realFilename);
		
		//사용자 수정
		int result = userService.updateUser(userVO);
		
		//정상 수정(성공)
		if(result == 1){
			response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
		}
		//정상 수정(실패)
		else{
			doGet(request, response);
		}
	}

}