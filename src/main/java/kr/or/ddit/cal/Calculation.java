package kr.or.ddit.cal;


/**
 * Calculation.java
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
 *
 * </pre>
 */
public class Calculation {
	
	public static void main(String[] args) {
		//sum 메소드 테스트
		Calculation cal = new Calculation();
		int result = cal.sum(10, 5);
		
		//예상되는 결과 값은 15
		if(result == 15){
			System.out.println("성공");
		}else{
			System.out.println("실패 : " + result);
		}
		
		//mul 메소드 테스트
		result = cal.mul(10, 5);
		
		//예상되는 결과 값은 50
		if(result == 50){
			System.out.println("성공");
		}else{
			System.out.println("실패 : " + result);
		}
			
	}
	
	/**
	 * Method : sum
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param param1
	 * @param param2
	 * @return
	 * Method 설명 : 두개의 인수를 더해주는 메소드
	 */
	public int sum(int param1, int param2){
		return param1 + param2;
	}
	
	
	/**
	 * Method : mul
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param param1
	 * @param param2
	 * @return
	 * Method 설명 : 두 인수의 곱을 계산하는 메소드
	 */
	public int mul(int param1, int param2){
		return param1 * param2;
	}
	
	/**
	 * Method : div
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param param1
	 * @param param2
	 * @return
	 * Method 설명 : 두 인수의 나눗셈을 계산하는 메소드
	 */
	public int div(int param1, int param2){
		if(param2 == 0){
			return 0;
		}else{
			return param1 / param2;
		}
	}

	
	public int sub(int i, int j) {
		return i - j;
	}
}