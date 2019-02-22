package kr.or.ddit.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	/**
	 * Method : viewResolve
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param request
	 * @param response
	 * @param viewInfo
	 * Method 설명 : viewInfo를 바탕으로 view처리 대상으로 위임
	 * 				처리 대상 : forward, redirect
	 */
	public void viewResolve(HttpServletRequest request, HttpServletResponse response, String viewInfo){
		if(viewInfo.startsWith("forward:")){
			//unhappy.substring(2) == happy
			//forward:/fornt/userList.jsp
			String uri = viewInfo.substring("forward:".length());
			try {
				request.getRequestDispatcher(uri).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(viewInfo.startsWith("redirect:")){
			
		}else{
			//error
		}
	}
}
