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

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

@WebServlet("/userForm")
@MultipartConfig(maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)
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
		
		String filename = "";
		String realFilename = "";
		
		if(duplicateUserVO == null){
			String userNm = request.getParameter("userNm");
			String alias = request.getParameter("alias");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String zipcode = request.getParameter("zipcode");
			String pass = request.getParameter("pass");
			
			UserVO userVO = new UserVO(userId, userNm, alias, addr1, addr2, zipcode, pass);
			
			//사용자 사진
			Part profilePart = request.getPart("profile");
			
			//사용자가 사진을 올린경우
			if(profilePart.getSize() > 0){
				//사용자 테이블 파일명을 저장
				//(실제 업로드한 파일명 - filename, 파일 충돌을 방지하기 위해 사용한 uuid - realFilename)
				String contentDisposition = profilePart.getHeader("Content-Disposition");
				filename = PartUtil.getFileNameFromPart(contentDisposition);
				realFilename = "d:\\picture\\" + UUID.randomUUID().toString();
				
				//디스크에 기록(d:\picture\ + realFileName)
				profilePart.write(realFilename);
				profilePart.delete();
			}
			//사용자가 사진을 올리지 않은 경우 filename, realFilename 모두 공백(위에서 초기화한값)
			
			//파일명, uuid 세팅
			userVO.setFilename(filename);
			userVO.setRealFilename(realFilename);
			
			//사용자 등록
			int result = userService.insertUser(userVO);
			
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