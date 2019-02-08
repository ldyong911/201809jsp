package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestCountFilter implements Filter{
	
	//key : uri, value : 요청 횟수
	private Map<String, Integer> counterMap;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		counterMap = new HashMap<String, Integer>();
		
		//application
		ServletContext application = filterConfig.getServletContext();
		
		application.setAttribute("counterMap", counterMap);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//servlet/jsp로 요청을 보내기전에 사전검사
		//전처리
		HttpServletRequest hsr = (HttpServletRequest)request; //URI 정보를 얻기 위해 형변환
		
		String uri = hsr.getRequestURI();
		Integer count = counterMap.get(uri);
		
		System.out.println("uri : " + uri);
		
		//최초 요청시
		if(count == null){
			counterMap.put(uri, 1);
		}else{
			counterMap.put(uri, ++count);
		}
		
		//Map<String, Integer> counterMap;
		
		//1.application 객체를 구한다
		//2.application 객체에 counterMap이라는 속성의 map객체가 있는지 확인
		//2-1.application 객체에 속성이 있을 경우 : 해당 속성 사용
		//2-2.application 객체에 속성이 없을 경우 :
		//2-2-1.Map<String, Integer> counterMap 객체 생성
		//2-2-2.생성된 맵 객체를 application 객체에 속성으로 등록
		
		//다음 필터 호출, 마지막 필터일 경우 최초 요청된 servlet 호출
		chain.doFilter(request, response);
		
		//servlet/jsp가 응답을 생성
		//후처리
	}

	@Override
	public void destroy() {
		
	}
	
}