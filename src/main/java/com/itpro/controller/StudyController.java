package com.itpro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudyController {
	
	private Logger logger = LoggerFactory.getLogger(StudyController.class);
	
	@RequestMapping(value="/studylist.do")
	public String studyList() {
		return "studyboard/studylist";
	}
	@RequestMapping(value="/studyinsert.do")
	public String studyInsert() {
		return "studyboard/studyinsert";
	}
	
}
