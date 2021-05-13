package com.itpro.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.dto.member.LoginDto;
import com.itpro.model.dto.member.RegDto;

@Controller
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberBiz biz;

	@Autowired
	private JavaMailSender mailSender;

	// 로그인폼
	@RequestMapping(value = "/login.do")
	public String login() {
		logger.info("[LOGIN]");

		return "login_join/login";
	}

	// 로그인
	@RequestMapping(value = "/ajaxlogin.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody LoginDto loginDto) {

		logger.info("[LOGIN]");
		LoginDto res = biz.login(loginDto);

		boolean check = false;
		if (res != null) {
			session.setAttribute("login", res);
			check = true;
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		return map;
	}

	// 로그아웃
	@RequestMapping("logout.do")
	public ModelAndView ajaxLogout(HttpSession session) {

		biz.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.do");
		mav.addObject("logout");

		return mav;
	}

	// 회원가입 선택페이지
	@RequestMapping(value = "/join.do")
	public String join() {
		logger.info("[JOIN]");

		return "login_join/join";
	}

	// 회원가입_개인 입력 폼
	@RequestMapping(value = "/join_userForm.do")
	public String userForm() {
		logger.info("[JOIN USER FORM]");

		return "login_join/join_userForm";
	}

	// 회원가입_기업 입력 폼
	@RequestMapping(value = "/join_bizForm.do")
	public String bizForm() {
		logger.info("[JOIN BIZ FORM]");

		return "login_join/join_bizForm";
	}

	// 회원가입_개인
	@RequestMapping(value = "/join_user.do")
	public String RegMember(RegDto regDto) {
		logger.info("[JOIN USER]");

		int res = biz.RegMember(regDto);
		if (res > 0) {
			return "redirect:main.do";

		} else {
			return "redirect:join_user.do";
		}
	}

	// 회원가입_기업
	@RequestMapping(value = "/join_biz.do")
	public String joinBiz() {
		logger.info("[JOIN BIZ]");

		return "login_join/join_biz";
	}

	// 아이디 중복 검사
	@RequestMapping(value = "/memberIdChk.do", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String m_id) {
		logger.info("[memberIdChk]");

		int res = biz.idCheck(m_id);

		logger.info("결과값 = " + res);

		if (res != 0) {

			return "fail"; // 중복 아이디가 존재

		} else {

			return "success"; // 중복 아이디 x

		}
	}
	
	// 이메일 중복 검사
		@RequestMapping(value = "/memberEmailChk.do", method = RequestMethod.POST)
		@ResponseBody
		public String memberEmailChkPOST(String m_email) {
			logger.info("[memberEmailChk]");

			int res = biz.emailChk(m_email);

			logger.info("결과값 = " + res);

			if (res != 0) {

				return "fail"; // 중복 이메일 존재

			} else {

				return "success"; // 중복 이메일 존재 x

			}
		}
	

	// 이메일 인증
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {

		// 뷰(View)로부터 넘어온 데이터 확인
		logger.info("이메일 데이터 전송 확인");
		logger.info("이메일 : " + email);

		// 인증번호(난수) 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호: " + checkNum);

		// 이메일 전송
		String setFrom = "31940436z@gmail.com"; // 보내는 이메일(발신)
		String toMail = email; // 입력한 이메일(수신)
		String title = "회원가입 인증 메일";// 제목
		String content = // 내용
				"홈페이지 방문을 감사드립니다. <br><br> 인증번호는 " + checkNum + " 입니다.<br> 해당 인증번호를 인증번호 확인란에 입력해주세요";

		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);// int타입의 생성한 인증번호를 String타입으로 변환해 반환

		return num;
	}

	// 개인회원 마이페이지 관련 컨트롤러
	@RequestMapping(value = "/mypage_user.do")
	public String mypage() {
		logger.info("MYPAGE USER");

		return "login_join/mypage_user";
	}

	// 개인 회원 정보수정 컨트롤러
	@RequestMapping(value = "/modify_user.do")
	public String modify() {
		logger.info("MYPAGE USER");

		return "login_join/modify_user";
	}

	// 이력서 관련 컨트롤러
	@RequestMapping(value = "/resume_list.do")
	public String resumeList() {
		logger.info("RESUEM LIST");

		return "resume/resume_list";
	}

	@RequestMapping(value = "/resume_form.do")
	public String resumeForm() {
		logger.info("RESUEM FORM");

		return "resume/resume_form";
	}

	@RequestMapping(value = "/resume_detail.do")
	public String resumeDetail() {
		logger.info("RESUEM DETIAL");

		return "resume/resume_detail";
	}

	@RequestMapping(value = "/resume_update.do")
	public String resumeUpdate() {
		logger.info("RESUEM UPDATE");

		return "resume/resume_update";
	}

	// 쪽지 관련 컨트롤러
	@RequestMapping(value = "/note_sendlist.do")
	public String noteSendList() {
		logger.info("NOTE SEND LIST");

		return "login_join/note_sendlist";
	}

	@RequestMapping(value = "/note_receivelist.do")
	public String noteReceiveList() {
		logger.info("NOTE RECEIVE LIST");

		return "login_join/note_receivelist";
	}

	//
	@RequestMapping(value = "/post_list.do")
	public String postList() {
		logger.info("NOTE LIST");

		return "login_join/post_list";
	}
}
