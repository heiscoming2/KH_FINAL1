package com.itpro.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.StudyBiz;
import com.itpro.model.dto.StudyDto;
import com.itpro.util.ClientInfo;

@Controller
public class StudyController {
	
	private Logger logger = LoggerFactory.getLogger(StudyController.class);
	
	@Autowired
	private StudyBiz studyBiz;
	
	@RequestMapping(value="/studylist.do")
	public String studyList() {
		logger.info("STUDY LIST");
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
}
