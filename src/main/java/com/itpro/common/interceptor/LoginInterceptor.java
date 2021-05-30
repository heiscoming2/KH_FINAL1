package com.itpro.common.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.util.JavaScriptResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private MemberBiz memberBiz;
	
	@Autowired
	JavaScriptResponse javaScriptResponse;
	
	// Controller 실행 요청 전에 수행되는 메소드 true값은 controller로 넘어가고 false는 다시 디스패처서플릿으로 돌아감.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {
		log.info("[Interceptor] : preHandle");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		//리퀘스트로부터 세션 정보를 받아온다.
		HttpSession session = request.getSession();

		//세션이 null 이면 로그인 페이지로 보낸다.
		if (request.getRequestURI().contains("/studyinsertform.do") ||
		    request.getRequestURI().contains("/qnainsertform.do") ||
		    request.getRequestURI().contains("/portfolioinsertform.do") ||
		    request.getRequestURI().contains("/projectinsertform.do") ||
		    request.getRequestURI().contains("/postlookup.do")
		    ) 
		    {
			if (session.getAttribute("login") == null) {
				javaScriptResponse.jsResponse(response, "로그인 후 이용 가능합니다.", "login.do");
				return false;
			}
		}

		
		
		if (request.getRequestURI().contains("/note_receivelist.do")
				||(request.getRequestURI().contains("/ad_list.do"))) {

		/*
		 * if(request.getRequestURI().contains("like.do")) {
		 * if(request.getSession().getAttribute("login")==null) { PrintWriter out =
		 * response.getWriter(); out.print("<script type='text/javascript'>");
		 * out.print("alert('로그인 후 좋아요가 가능합니다.');");
		 * out.print("location.href='login.do';"); out.print("</script>"); return false;
		 * } }
		 */
		}
		


		//기업회원 글작성X 시작
		if (request.getRequestURI().contains("/studyinsertform.do")// 스터디 글쓰기
				|| (request.getRequestURI().contains("/projectinsertform.do"))// 프로젝트 글쓰기
				|| (request.getRequestURI().contains("/portfolioinsertform.do"))) { //포트폴리오 글쓰기
			MemberDto memberDto = (MemberDto) session.getAttribute("login");
			String m_type = memberDto.getM_type();
			if (m_type.equals("기업회원")) {
				int m_no = memberDto.getM_no();
				MemberDto bizMemberDto = memberBiz.selectOne(m_no);
				String m_admin_cert = bizMemberDto.getM_admin_cert();

				// 접근 불가 처리 알림창
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('개인회원만 작성 가능합니다.');");
				out.print("location.href='main.do';");
				out.print("</script>");
				return false;
			}
		}//기업회원 글작성X 끝
		
		// 기업회원 글작성X 시작
		if (request.getRequestURI().contains("/portfolioinsertform.do")) { // 포트폴리오 이력서 미작성자 작성X
			MemberDto memberDto = (MemberDto) session.getAttribute("login");
			String m_resumechk = memberDto.getM_resumechk();
			if (m_resumechk.equals("N")) {
				// 접근 불가 처리 알림창
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('이력서 작성 후 포트폴리오 작성이 가능합니다.');");
				out.print("location.href='main.do';");
				out.print("</script>");
				return false;
			}
		} // 기업회원 글작성X 끝
		
		//기업회원 승인 전 접근X	
		if (request.getRequestURI().contains("/like.do")//좋아요는 안눌리는데 알람 안뜨넹ㅠㅠ
				||(request.getRequestURI().contains("/replyinsert.do"))//댓글
				||(request.getRequestURI().contains("/note_receivelist.do"))//쪽지
				||(request.getRequestURI().contains("/ad_list.do"))) { //광고
			MemberDto memberDto = (MemberDto) session.getAttribute("login");
			String m_type = memberDto.getM_type();
			if (m_type.equals("기업회원")) {
				int m_no = memberDto.getM_no();
				MemberDto bizMemberDto = memberBiz.selectOne(m_no);
				String m_admin_cert = bizMemberDto.getM_admin_cert();
				
				if (m_admin_cert.equals("N")) {
					// 접근 불가 처리
					PrintWriter out = response.getWriter();
					out.print("<script type='text/javascript'>");
					out.print("alert('관리자 승인 후 사용합니다');");
					out.print("location.href='main.do';");
					out.print("</script>");
					return false;
				}
			}
		}//기업회원 승인 전 접근X
		return true;

	}

	// view 단으로 forward 되기 전에 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		log.info("[Interceptor] : postHndle");
	}

	// view까지 처리가 끝난 후에 수행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		log.info("[Interceptor] : afterCompletion");

	}
}
