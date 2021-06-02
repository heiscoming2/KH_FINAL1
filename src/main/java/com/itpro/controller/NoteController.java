package com.itpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	// 쪽지팝업(쪽지 작성창)
	@RequestMapping(value = "/noteForm.do")
	public String noteSend() {
		logger.info("NOTE FORM");

		return "note/note_form";
	}

	// 쪽지 보내기
	@RequestMapping(value = "noteSend.do", method = RequestMethod.POST)
	public String noteSend(Model model, NoteDto noteDto, HttpServletResponse response, HttpSession session) throws IOException {
		logger.info("NOTE SEND");

		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			int n_sender = login.getM_no();
			noteDto.setN_sender(n_sender);
		}

		int res = biz.noteSend(noteDto);
		if (res > 0) {
			model.addAttribute("message", "");
			return "note/noteSend";
			
		} else {
			model.addAttribute("message", "전송에 실패했습니다.");
			return "note/noteSend";
		}
	}

	// 받은 쪽지 읽기
	@RequestMapping(value = "/receiveDetail.do")
	public String receiveDetail(Model model, HttpSession session, int n_no) {
		logger.info("NOTE READ");
		
		int n_receiver = 0;

		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			n_receiver = login.getM_no();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("n_receiver", n_receiver);
		map.put("n_no", n_no);
		NoteDto noteDto = biz.receiveDetail(map);
		
		model.addAttribute("noteDto", noteDto);

		return "note/note_receiveDetail";
	}

}
