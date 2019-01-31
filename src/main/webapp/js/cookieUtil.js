/**
 * @param cookieName
 * 쿠키 이름으로 해당 쿠키 값을 조회
 */
function getCookieValue(cookieName){
	var cookieArray = document.cookie.split("; ");
	var cookieValue = "";
	
	for(var i=0; i<cookieArray.length; i++){
		var cookie = cookieArray[i];
		
		if(cookieName == cookie.split("=")[0]){ //cookieName
			cookieValue = cookie.split("=")[1]; //cookieValue
			break;
		}
	}
	
	return cookieValue;
}

/**
 * @param cookieName
 * @param cookieValue
 * @param expires
 * 쿠키 생성
 */
function setCookie(cookieName, cookieValue, expires){
	//현재 날짜 기준으로 expires 날짜 만큼 유효한 cookie 생성
	//쿠키 생성 방법 : document.cookie = "cookie 문자열 포맷";
	//cookie 문자열 포맷 : cookieName=cookieValue; path=/; expires=gmtString
	var today = new Date();
	today.setDate(today.getDate() + parseInt(expires));
	document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
	
}

/**
 * @param cookieName
 * 쿠키 삭제
 */
function deleteCookie(cookieName){
	var today = new Date(); //오늘날짜
	today.setDate(today.getDate() - 1); //하루 전 날짜
	
	document.cookie = cookieName + "=; path=/; expires=" + today.toGMTString();
}