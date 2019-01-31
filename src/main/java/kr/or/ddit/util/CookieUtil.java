package kr.or.ddit.util;

public class CookieUtil {
	private String[] cookieArray;
	
	public CookieUtil(String cookieString) {
		cookieArray = cookieString.split("; ");
	}

	/**
	 * Method : getCookieValue
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param cookieName
	 * @return
	 * Method 설명 : 쿠키이름에 해당하는 쿠키 값을 조회
	 */
	public String getCookieValue(String cookieName) {
		String cookieValue = "";
		
		for(int i=0; i<cookieArray.length; i++){
			if(cookieName.equals(cookieArray[i].split("=")[0])){
				cookieValue = cookieArray[i].split("=")[1];
				break;
			}
		}
		
		return cookieValue;
	}
	
}