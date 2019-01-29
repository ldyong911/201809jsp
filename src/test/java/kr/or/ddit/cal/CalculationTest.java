package kr.or.ddit.cal;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculationTest {
	
	private Calculation cal;
	
	// @Before 어노테이션은 @Test 어노테이션이 적용된 테스트 메소드를 실행하기 전에 매번 실행된다
	@Before
	public void setup(){
		System.out.println("setup");
		cal = new Calculation();
	}
	
	@After
	public void tearDown(){
		System.out.println("tearDown");
	}
	
	// @Test 어노테이션이 붙은 메소드를 테스트 메소드라고 한다
	// 테스트 메소드 명명 규칙 : test + 테스트 대상 메소드
	// ex : sum --> testSum
	// 성공 : 1.테스트 메소드가 예외 발생없이 정상적으로 실행된 경우
	//       2.assert관련 메소드가 있을경우 assert구문을 정상적으로 통과한 경우
	@Test
	public void testSum() {
		/***Given***/
		
		/***When***/
		int result = cal.sum(10, 5);

		/***Then***/
		// 예상되는 결과 값은 15
		assertEquals(15, result);
	}

	@Test
	public void testMul(){
		/***Given***/
		
		/***When***/
		int result = cal.mul(5, 10);
		
		/***Then***/
		assertEquals(50, result);
	}
	
	@Test
	public void testDiv(){
		/***Given***/
		
		/***When***/
		int result = cal.div(10, 5);

		/***Then***/
		assertEquals(2, result);
	}
	
	@Test
	public void testDiv_divByZero(){
		/***Given***/
		
		/***When***/
		int result = cal.div(10, 0);

		/***Then***/
		assertEquals(0, result);
	}
	
	@Test
	public void testEfficentlySum(){
		int sum = 0;
		int start = 1;
		int end = 10;
		
		sum = (end *(end+1))/2 - ((start*(start+1))/2 - start);
		
		assertEquals(55, sum);
	}
	
	@Test
	public void testSub(){
		/***Given***/
		
		/***When***/
		int result = cal.sub(10, 5);
		
		/***Then***/
		assertEquals(5, result);
	}
	// TDD : Test Driven Development
	
}