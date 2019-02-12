package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {

	/**
	 * Method : testCookieStringParsing
	 * 작성자 : pc11
	 * 변경이력 :
	 * Method 설명 : cookie 문자열 파싱 테스트
	 */
	@Test
	public void testCookieStringParsing() {
		/***Given***/
		String cookieString = "userId=brown; rememberme=y; test=value";
		CookieUtil cookieUtil = new CookieUtil(cookieString);
		
		/***When***/
		String cookieValue = cookieUtil.getCookieValue("userId");
		String cookieValue2 = cookieUtil.getCookieValue("rememberme");
		String cookieValue3 = cookieUtil.getCookieValue("test");
		
		/***Then***/
		assertEquals("brown", cookieValue);
		assertEquals("y", cookieValue2);
		assertEquals("value", cookieValue3);
		
	}
	
	/**
	 * Method : testGetFileNameFromPart
	 * 작성자 : pc11
	 * 변경이력 :
	 * Method 설명 : part의 Content-Disposition 헤더로부터 filename을 가져온다
	 */
	@Test
	public void testGetFileNameFromPart(){
		/***Given***/
		String contentDisposition = "form-data; name=\"fileUpload\"; filename=\"real.jpg\"";
		//form-data; name="fileUpload"; filename="real.jpg"
		
		/***When***/
		String fileName = PartUtil.getFileNameFromPart(contentDisposition);
		String fileName2 = PartUtil.getFileNameFromPart2(contentDisposition);
		
		/***Then***/
		assertEquals("real.jpg", fileName);
		assertEquals("real.jpg", fileName2);
		
	}

}