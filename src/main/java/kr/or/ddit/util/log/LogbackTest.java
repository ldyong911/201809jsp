package kr.or.ddit.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogbackTest {
	//1. logger 선언
//	private Logger logger = LoggerFactory.getLogger(Class);
	private Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	
//	private Logger logger = LoggerFactory.getLogger("kr.or.ddit.util.log.Logback");
//	<logger name="kr.or.ddit" level="DEBUG"/>
	
	public LogbackTest(){
		System.out.println("test");
		logger.trace("trace " + "test");
		logger.debug("debug " + "test");
		logger.info("info " + "test");
		logger.warn("warn " + "test");
		logger.error("error " + "test");
		logger.error("error {}, {}, {}", "test", "test2", "test3"); //{}를 사용할때는 +대신 ,를 쓰며 인자를 의미
	}
	
	public static void main(String[] args) {
		LogbackTest logbackTest = new LogbackTest();
		
	}
}