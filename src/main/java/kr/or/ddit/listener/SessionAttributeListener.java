package kr.or.ddit.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionAttributeListener implements HttpSessionAttributeListener{
	private Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		logger.debug("SessionAttributeListener added : {} :{}",event.getName(), event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.debug("SessionAttributeListener remove : {} :{}",event.getName(), event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		logger.debug("SessionAttributeListener replace : {} :{}",event.getName(), event.getValue());
	}

}
