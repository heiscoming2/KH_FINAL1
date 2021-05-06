package com.itpro.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	//Controller 실행 요청 전에 수행되는 메소드  true값은 controller로 넘어가고  false는 다시 디스패처서플릿으로 돌아감. 
 	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		logger.info("[Interceptor] : preHandle");
		System.out.println(request.getServletContext().getRealPath("/"));
		
		
		
		return true;
	};
	
	//view 단으로 forward 되기 전에 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
				ModelAndView modelAndView) {
		logger.info("[Interceptor] : postHndle");
	}
	
	//view까지 처리가 끝난 후에 수행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logger.info("[Interceptor] : afterCompletion");
		
	}
}
