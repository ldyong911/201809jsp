package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class DefaultUntCdFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//모든 요청에 대해 unt_cd 파라미터가 추가되도록 defaultUntCdWrapper를 사용 
		DefaultUntCdWrapper defaultUntCdWrapper = new DefaultUntCdWrapper((HttpServletRequest)request);
		
		//원본 request객체가 아니라 재정의한 request 객체를 다음 filter(혹은 서블릿)로 전송
		//chain.doFilter(request, response);
		chain.doFilter(defaultUntCdWrapper, response);
	}

	@Override
	public void destroy() {
		
	}
	
}