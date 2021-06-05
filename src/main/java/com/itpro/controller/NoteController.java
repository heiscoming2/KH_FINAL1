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
import org.springframework.web.bind.annotation.RequestParam;
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
	public String noteSend(@RequestParam(value="m_nickname", required=false, defaultValue="") String m_nickname,
						   Model model) {
		logger.info("NOTE FORM");
		//if 받는 사람이 없는 경우(receiver_no==0)
		//쪽지창에서 직접 쪽지보내기를 누른 경우이며
		//바로 쪽지 창으로 보내주고
		
		//else 받는 사람이 있는 경우 (게시판 등 프로필을 누르고 쪽지보내기 누른 경우)
		//receiver_no를 받아와서 받는 사람 닉네임을 불러와 receiver_no와 닉네임을 함께 model에 담아 전송한다.
		if(m_nickname.equals("")) {
			return "note/note_form";
		} else {
			model.addAttribute("m_nickname",m_nickname);
			return "note/note_form";
		}
		
		
		
		
	}

	// 쪽지 보내기
	@RequestMapping(value = "/noteSend.do", method = RequestMethod.POST)
	public String noteSend(Model model, NoteDto noteDto, HttpServletResponse response, HttpSession session)
			throws IOException {
		logger.info("NOTE SEND");
		
		//세션에서 이미 null값이면 튕겨서 여기로 못옴
		/*
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			int n_sender = login.getM_no();
			noteDto.setN_sender(n_sender);
		}
		*/
		
		MemberDto login = (MemberDto) session.getAttribute("login");
		int n_sender = login.getM_no();
		noteDto.setN_sender(n_sender);
		
		int res = biz.noteSend(noteDto);
		if (res > 0) {
			model.addAttribute("message", "");
			return "note/noteSend";

		} else {
			model.addAttribute("message", "전송에 실패했습니다.");
			return "note/noteSend";
		}
	}

	// 내가 받은 쪽지 읽기
	@RequestMapping(value = "/receiveDetail.do")
	public String receiveDetail(Model model, HttpSession session, int n_no, NoteDto updateNoteDto) {
		logger.info("NOTE RECEIVE READ");

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
		
		//쪽지 읽은 시간 업데이트 ->읽을때 같이 처리하는거 아닌가요? ㅠ
		/*
		 * int readDate = biz.updateReadDate(updateNoteDto);
		 * model.addAttribute("readDate", readDate);
		 */

		return "note/note_receiveDetail";
	}

	// 내가 보낸 쪽지 읽기
	@RequestMapping(value = "/sendDetail.do")
	public String sendDetail(Model model, HttpSession session, int n_no) {
		logger.info("NOTE SEND READ");

		int n_sender = 0;

		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			n_sender = login.getM_no();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("n_sender", n_sender);
		map.put("n_no", n_no);
		NoteDto noteDto = biz.sendDetail(map);

		model.addAttribute("noteDto", noteDto);

		return "note/note_sendDetail";
	}

	// 쪽지 개별삭제(받은쪽지)
	@RequestMapping(value = "/note_delete.do")
	public String noteDelete(int n_no) {
		logger.info("NOTE RECEIVE DELETE");

		int res = biz.noteDelete(n_no);
		if (res > 0) {
			return "redirect:note_receivelist.do";
		} else {
			return "redirect:note_receiveDetail.do?n_no=" + n_no;
		}

	}

	// 쪽지 개별삭제(보낸쪽지)
	@RequestMapping(value = "/note_sendDelete.do")
	public String noteSendDelete(int n_no) {
		logger.info("NOTE RECEIVE DELETE");

		int res = biz.noteDelete(n_no);
		if (res > 0) {
			return "redirect:note_sendlist.do";
		} else {
			return "redirect:note_sendDetail.do?n_no=" + n_no;
		}

	}
	
	//채용 여부 쪽지 자동 발송
	@RequestMapping(value = "/companyapplicationsendnote.do")
	@ResponseBody
	public boolean companyApplicationSendNote(@RequestParam("r_no") int r_no, 
			@RequestParam("bd_no") int bd_no, 
			@RequestParam("ca_status") char ca_status) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("r_no", r_no);
		map.put("bd_no", bd_no);
		map.put("ca_status", ca_status);
		int res = biz.companyApplicationSendNote(map);
		
		return res>0?true:false;
	
	}
	
	

}
