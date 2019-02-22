package kr.or.ddit.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HandlerInvoker.java
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
 * controller 실행, 실행 결과로 리턴된 view정보를 리턴
 * </pre>
 */
public class HandlerInvoker {
	public String Invoke(HttpServletRequest request, HttpServletResponse response, CommonController controller){
		String viewInfo = controller.process(request, response);
		return viewInfo;
	}
}