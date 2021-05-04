package com.itpro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itpro.model.biz.ManageMemberBiz;
import com.itpro.model.dto.admin.ManageMemberDto;

@Controller
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	ManageMemberBiz managememberbiz;
	
	
	
	//회원관리 컨트롤러
	@RequestMapping(value="/member_list.do",  method = RequestMethod.GET)
	public String member_list(Model model) {
		List<ManageMemberDto> member_list=ManageMemberBiz.selectList();
		model.addAttribute("member_list",member_list);
		
		logger.info("member_list");
		
		return "admin/member_list";
	}
	
	@RequestMapping(value="/member_detail.do")
	public String join() {
		logger.info("member_detail");
		
		return "admin/member_detail";
	}
	/*
	@RequestMapping(value="/join_user.do")
	public String joinUser() {
		logger.info("JOIN USER");
		
		return "login_join/join_user";
	}
	
	@RequestMapping(value="/join_biz.do")
	public String joinBiz() {
		logger.info("JOIN BIZ");
		
		return "login_join/join_biz";
	}
	
	
	//개인회원 마이페이지 관련 컨트롤러
	@RequestMapping(value="/mypage_user.do")
	public String mypage() {
		logger.info("MYPAGE USER");
		
		return "login_join/mypage_user";
	}
	
	//개인 회원 정보수정 컨트롤러
	@RequestMapping(value="/modify_user.do")
	public String modify() {
		logger.info("MYPAGE USER");
		
		return "login_join/modify_user";
	}
	
	//이력서 관련 컨트롤러
	@RequestMapping(value="/resume_list.do")
	public String resumeList() {
		logger.info("RESUEM LIST");
		
		return "login_join/resume_list";
	}
	
	@RequestMapping(value="/resume_form.do")
	public String resumeForm() {
		logger.info("RESUEM FORM");
		
		return "login_join/resume_form";
	}
	
	@RequestMapping(value="/resume_detail.do")
	public String resumeDetail() {
		logger.info("RESUEM DETIAL");
		
		return "login_join/resume_detail";
	}
	
	@RequestMapping(value="/resume_update.do")
	public String resumeUpdate() {
		logger.info("RESUEM UPDATE");
		
		return "login_join/resume_update";
	}
	
	
	//쪽지 관련 컨트롤러
	@RequestMapping(value="/note_sendlist.do")
	public String noteSendList() {
		logger.info("NOTE SEND LIST");
		
		return "login_join/note_sendlist";
	}
	@RequestMapping(value="/note_receivelist.do")
	public String noteReceiveList() {
		logger.info("NOTE RECEIVE LIST");
		
		return "login_join/note_receivelist";
	}
	
	//
	@RequestMapping(value="/post_list.do")
	public String postList() {
		logger.info("NOTE LIST");
		
		return "login_join/post_list";
	}*/
}
