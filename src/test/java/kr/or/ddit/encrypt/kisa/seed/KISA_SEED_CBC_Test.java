package kr.or.ddit.encrypt.kisa.seed;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * KISA_SEED_CBC_Test.java
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
 * 복호화가 가능한 seed 알고리즘 테스트
 *
 * </pre>
 */
public class KISA_SEED_CBC_Test {
	private Logger logger = LoggerFactory.getLogger(KISA_SEED_CBC_Test.class);
	
	/**
	 * Method : testEncrypt
	 * 작성자 : pc11
	 * 변경이력 :
	 * Method 설명 : 암호화-복호화 테스트
	 */
	@Test
	public void testEncrypt() {
		/***Given***/
		String plainText = "brown";
		
		/***When***/
		String encryptText = KISA_SEED_CBC.Encrypt(plainText);
		logger.debug("encryptText : {}", encryptText);
		
		String decryptText = KISA_SEED_CBC.Decrypt(encryptText);
		logger.debug("decryptText : {}", decryptText);
		
		/***Then***/
		assertEquals(plainText, decryptText);
		
	}

}