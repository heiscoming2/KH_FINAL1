package com.itpro.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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
import com.itpro.model.biz.NoteBiz;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.note.NoteDto;
import com.itpro.model.dto.resume.ResumeDto;

@Controller
public class NoteController {
	private Logger logger = LoggerFactory.getLogger(NoteController.class);

	@Autowired
	private NoteBiz biz;

	// 내가 받은 쪽지 목록 조회
	@RequestMapping(value = "/note_receivelist.do")
	public String noteReceiveList(Model model, HttpSession session) {
		logger.info("NOTE RECEIVE LIST");

		int n_receiver = 0;

		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			n_receiver = login.getM_no();
		}

		List<NoteDto> receiveList = biz.receiveList(n_receiver);
		model.addAttribute("receiveList", receiveList);

		/*
		 * List<NoteDto> list = biz.receiveList(); Integer count = biz.countNewNote();
		 * logger.info("count: " + count);
		 */

		return "note/note_receivelist";
	}

	// 보낸 쪽지 목록 조회
	@RequestMapping(value = "/note_sendlist.do")
	public String noteSendList(Model model, HttpSession session) {
		logger.info("NOTE SEND LIST");
		
		int n_sender = 0;

		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			n_sender = login.getM_no();
		}

		List<NoteDto> sendList = biz.sendList(n_sender);
		model.addAttribute("sendList", sendList);


		return "note/note_sendlist";
	}

	// 쪽지 보내기
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String noteSend(Message message, Model model) {
		logger.info("NOTE SEND");
		
		
		return "note/note_sendlist";
	}

}
