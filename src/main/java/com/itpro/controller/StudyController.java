package com.itpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.StudyBiz;
import com.itpro.model.dto.StudyDto;
import com.itpro.model.dto.StudyListDto;
import com.itpro.util.ClientInfo;

@Controller
public class StudyController {
	
	private Logger logger = LoggerFactory.getLogger(StudyController.class);
	
	@Autowired
	private StudyBiz studyBiz;
	
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
	public String studyInsert(HttpServletRequest request, StudyDto studyDto) {
		logger.info("STUDY INSERT");
		studyDto.setBd_writerip(new ClientInfo().getClientIp(request));
		studyBiz.insert(studyDto);
		return "studyboard/studyinsertform";
	}	
	
	@RequestMapping(value="/studydetail.do")
	public String studyDetail(HttpServletRequest request, StudyDto studyDto) {
		logger.info("STUDY DETAIL");
		return "studyboard/studydetail";
	}	
}
