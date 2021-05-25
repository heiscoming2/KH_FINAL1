package com.itpro.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.Message;
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

import com.itpro.model.biz.Login_joinBiz;
import com.itpro.model.biz.MemberBiz;
import com.itpro.model.biz.ResumeBiz;
import com.itpro.model.dto.member.MemberDto;

@Controller
public class ResumeController {
	private Logger logger = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	private ResumeBiz resumeBiz;

	// 이력서 목록
	@RequestMapping(value = "/resume_list.do")
	public String resumeList() {
		logger.info("RESUEM LIST");

		return "resume/resume_list";
	}

	//이력서 등록폼으로 이동
	@RequestMapping(value = "/resume_form.do")
	public String resumeForm(HttpSession session, Model model) {
		logger.info("RESUEM FORM");
		
		if (session.getAttribute("login") != null) {
			MemberDto res = (MemberDto) session.getAttribute("login");
			int m_no = res.getM_no();
			MemberDto resumeInsert = resumeBiz.selectOne(m_no);
			model.addAttribute("resumeInsert", resumeInsert);

			return "member/update_user";
		}

		return "resume/resume_form";
	}

	//이력서 상세페이지 이동
	@RequestMapping(value = "/resume_detail.do")
	public String resumeDetail() {
		logger.info("RESUEM DETIAL");

		return "resume/resume_detail";
	}

	//이력서 수정폼으로 이동
	@RequestMapping(value = "/resume_update.do")
	public String resumeUpdate() {
		logger.info("RESUEM UPDATE");

		return "resume/resume_update";
	}

}
