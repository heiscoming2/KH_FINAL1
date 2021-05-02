package com.itpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.biz.StudyBiz;
import com.itpro.model.dto.ReplyDto;
import com.itpro.model.dto.StudyDetailDto;
import com.itpro.model.dto.StudyDto;
import com.itpro.model.dto.StudyListDto;
import com.itpro.util.ClientInfo;

@Controller
public class StudyController {
	
	private Logger logger = LoggerFactory.getLogger(StudyController.class);
	
	@Autowired
	private StudyBiz studyBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@RequestMapping(value="/studylist.do")
	public String studyList(Model model) {
		
		logger.info("STUDY LIST");
		//스터디 글 목록을 받아 model에 담아준다.
		List<StudyListDto> studyList = studyBiz.selectList();
		model.addAttribute("studyList",studyList);
		
		return "studyboard/studylist";
	}
	
	@RequestMapping(value="/studyinsertform.do")
	public String studyInsertForm() {
		logger.info("STUDY INSERT FORM");
		return "studyboard/studyinsertform";
	}
	
	@RequestMapping(value="/studyinsert.do")
	public String studyInsert(HttpServletRequest request, HttpServletResponse response, StudyDto studyDto) {
		logger.info("STUDY INSERT");
		//ClientInfo의 getClientIp에 request를 전달하여 ip 정보를 얻어와 StudyDto에 저장
		studyDto.setBd_writerip(new ClientInfo().getClientIp(request));
		studyBiz.studyInsert(studyDto);
		return "redirect:studylist.do";
	}	
	
	@RequestMapping(value="/studydetail.do")
	public String studyDetail(Model model, @RequestParam(value="bd_no") int bd_no) {
		logger.info("STUDY DETAIL");
		
		//조회수 중복 카운트 방지를 위해 쿠기 사용
		//bd_no가 쿠키에 있는 경우 조회수 증가, 그렇지 않은 경우 조회수 유지
		//
		
		//스터디 selectone해서 model에 담아준다.
		StudyDetailDto studyDetailDto = studyBiz.selectOne(bd_no);
		
		//테스트 나중에 삭제
		logger.info(""+studyDetailDto.getM_img_path());
		logger.info(""+studyDetailDto.getM_img());
		logger.info(""+studyDetailDto.getM_name());
		logger.info(""+studyDetailDto.getBd_createddate());
		logger.info(""+studyDetailDto.getBd_modifydate());
		logger.info(""+studyDetailDto.getBd_no());
		logger.info(""+studyDetailDto.getBd_title());
		logger.info(""+studyDetailDto.getBd_content());
		logger.info(""+studyDetailDto.getSt_addr1());
		logger.info(""+studyDetailDto.getSt_addr2());
		logger.info(""+studyDetailDto.getSt_addrdetail());
		logger.info(""+studyDetailDto.getSt_nowperson());
		logger.info(""+studyDetailDto.getSt_closeperson());
		
		model.addAttribute("studyDetailDto",studyDetailDto);
		
		//댓글 list받아와 model에 담아준다.
		List<ReplyDto> replyList = replyBiz.selectList();
		model.addAttribute("replyList",replyList);
		
		return "studyboard/studydetail";
	}	
}
