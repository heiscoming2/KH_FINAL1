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
import com.itpro.model.dto.member.MemberDto;

@Controller
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberBiz biz;

	// 개인회원 마이페이지 관련 컨트롤러
	@RequestMapping(value = "/mypage_user.do")
	public String mypage() {
		logger.info("MYPAGE USER");

		return "member/mypage_user";
	}

	// 개인회원 정보수정폼으로 이동
	@RequestMapping(value = "/user_update_form.do")
	public String modify(HttpSession session) {
		logger.info("MYPAGE USER");
		
		/* 세션에 담긴거 컨트롤러로 가져와서 사용해야 할때
		LoginDto loginDto = (LoginDto) session.getAttribute("login");		
		logger.info("loginDto: " + loginDto);
		logger.info("loginDto.getM_nickname(): " + loginDto.getM_nickname());
		*/

		return "member/update_user";
	}

	// 개인회원 정보수정 처리
	@RequestMapping("/user_update.do")
	public String update(MemberDto loginDto) {
		logger.info("MEMBER UPDATE");

		int res = biz.update(loginDto);
		if (res > 0) {
			return "redirect:mypage_user.do";

		} else {
			return "redirect:user_update_form.do";
		}
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

		return "member/post_list";
	}
}
