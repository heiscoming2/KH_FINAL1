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
import org.springframework.web.bind.annotation.RequestParam;
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
	public String update(HttpSession session, Model model) {
		logger.info("MYPAGE USER");

		/*
		MemberDto res = biz.login(loginDto);

		boolean check = false;
		if (res != null) {
			session.setAttribute("login", res);
			check = true;
		}
	 */
	
//	if(session.getAttribute("m_no") != null) {
//		int m_no = (int) session.getAttribute("m_no");
//		MemberDto update = biz.selectOne(m_no);
//		model.addAttribute("update", update);

		if (session.getAttribute("login") != null) {
			MemberDto res = (MemberDto) session.getAttribute("login");
			int m_no = res.getM_no();
			MemberDto update = biz.selectOne(m_no);
			model.addAttribute("updateUser", update);
			
			return "member/update_user";
		}

		return "redirect:main.do";
	}

	///////////////////////////// 기업회원

	// 기업회원 마이페이지 관련 컨트롤러
	@RequestMapping(value = "/mypage_biz.do")
	public String mypage_biz() {
		logger.info("MYPAGE BIZ");

		return "member/mypage_biz";
	}

	// 기업회원 정보수정폼으로 이동
	@RequestMapping(value = "/biz_update_form.do")
	public String modifyBiz(HttpSession session) {
		logger.info("BIZ UPDATE FORM");

		return "member/update_biz";
	}

	//////////////////////////////////// 회원탈퇴

	// 회원탈퇴 페이지이동
	@RequestMapping(value = "/deleteForm.do")
	public String deleteForm() {
		logger.info("DELETE Form");

		return "member/delete_member";
	}

	// 회원탈퇴 처리
	@RequestMapping(value = "/deleteMember.do")
	public String deleteMember(@RequestParam(required = false) String m_id, @RequestParam(required = false) String m_pw,
			HttpSession session) {
		logger.info("DELETE MEMBER");

		boolean res = biz.checkPw(m_id, m_pw);
		if (res) {
			biz.deleteMember(m_id);
			session.invalidate();

			return "redirect:main.do";
		} else {
			return "redirect:deleteForm.do";
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

	// 작성글 목록
	@RequestMapping(value = "/post_list.do")
	public String postList() {
		logger.info("LIST_POST");

		return "member/list_post";
	}

	// 기업 광고내역
	@RequestMapping(value = "/ad_list.do")
	public String adList() {
		logger.info("AD LIST");

		return "admin/ad_list";
	}
}
