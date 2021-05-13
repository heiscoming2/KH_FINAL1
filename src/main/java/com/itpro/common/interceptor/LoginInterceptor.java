package com.itpro.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.dto.member.LoginDto;

public class LoginInterceptor implements HandlerInterceptor{

	@Autowired
	private MemberBiz memberBiz;
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	//Controller 실행 요청 전에 수행되는 메소드  true값은 controller로 넘어가고  false는 다시 디스패처서플릿으로 돌아감. 
 	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		logger.info("[Interceptor] : preHandle");
	//	logger.info("MemberBiz:", (memberBiz == null) ? "NULL" : memberBiz);
		
		setLoginDto(request);
		
		System.out.println(request.getServletContext().getRealPath("/"));
		
		//비 로그인으로 접근 가능한 페이지(주석 지워서 사용)
		/* 
		if(request.getRequestURI().contains("/main.do") //메인
				||request.getRequestURI().contains("/login.do") //로그인폼 
				|| request.getRequestURI().contains("/ajaxlogin.do") //로그인
				|| request.getSession().getAttribute("login")!=null
				|| request.getRequestURI().contains("/join.do") //회원가입 선택
				|| request.getRequestURI().contains("/join_userForm.do") //회원가입폼
				|| request.getRequestURI().contains("/join_bizForm.do") //회원가입폼
				|| request.getRequestURI().contains("/join_user.do") //회원가입
				){
				
			return true;
		} 
		
		if(request.getSession().getAttribute("login") == null) {//로그인 상태가 아니면 로그인 폼으로
			response.sendRedirect("login.do");
			return false;
		}				
		*/
		return true;
	}
 	
 	private void setLoginDto(HttpServletRequest request) {
 		logger.info("setLoginDto()");
 		
 		HttpSession session = request.getSession();
 		Integer m_no = (Integer) session.getAttribute("m_no");
 		if (m_no == null) {
 			logger.info("m_no == null");
 			return; // early return;
 		}
 		
		LoginDto loginDto = memberBiz.select(m_no);
		logger.info("loginDto: " + loginDto);
		logger.info("loginDto.getM_no(): " + loginDto.getM_no());
 		
		session.setAttribute("login", loginDto);
 	}
	
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
