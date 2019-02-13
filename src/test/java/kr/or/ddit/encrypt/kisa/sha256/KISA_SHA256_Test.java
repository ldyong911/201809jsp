package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * KISA_SHA256_Test.java
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
 * KISA SHA256 hash 알고리즘 테스트
 *
 * </pre>
 */
public class KISA_SHA256_Test {
	private Logger logger = LoggerFactory.getLogger(KISA_SHA256_Test.class);
	
	/**
	 * Method : testEncrypt
	 * 작성자 : pc11
	 * 변경이력 :
	 * Method 설명 : 암호화 테스트
	 */
	@Test
	public void testEncrypt() {
		/***Given***/
		String plainText = "brown_pass";
		
		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);
		logger.debug("encryptText : {}", encryptText);
		
		/***Then***/
		assertEquals("48a77d8abb246ddebe4c0f43164c5446f72536597c6f1919a7536b62cad8dbb", encryptText);
		
	}

}