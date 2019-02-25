package kr.or.ddit.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.user.model.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentUserListener implements HttpSessionAttributeListener{
	private Logger logger = LoggerFactory.getLogger(CurrentUserListener.class);
	private List<UserVO> currentLoginUserList;
	
	public CurrentUserListener (){
		currentLoginUserList= new ArrayList<UserVO>();
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//신규 사용자 로그인 여부
		if("userVo".equals(event.getName())){
			UserVO userVO = (UserVO)event.getValue();
			currentLoginUserList.add(userVO);
			ServletContext application = event.getSession().getServletContext();
			
			application.setAttribute("currentLoginUserList",currentLoginUserList);
			
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if("userVO".equals(event.getName())){
			UserVO userVO = (UserVO) event.getValue();
			currentLoginUserList.remove(userVO);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		attributeAdded(event);
	}

}