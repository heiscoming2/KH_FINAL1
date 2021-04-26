package com.itpro.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.CompanyCrawlingBiz;
import com.itpro.model.dto.CompanyCrawlingDto;
import com.itpro.util.CompanyCrawler;

@Controller
public class CompanyCrawlingController {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyCrawlingController.class);
	private CompanyCrawlingBiz companyCrawlingBiz;
	
	@RequestMapping(value="/companycrawlinglist.do")
	public String companyCrawlingList() {
		return "companycrawling/companycrawlinglist";
	}
	
	@RequestMapping(value="/companycrawlingupdate.do")
	public String companyCrawlingInsert() {
		
		CompanyCrawler companyCralwer = new CompanyCrawler();
		List<CompanyCrawlingDto> companyCrawlingList = companyCralwer.getCompanyCrawlingList();
		companyCrawlingBiz.insert(companyCrawlingList);
		
		
		
		
		
		return "companycrawling/companycrawlinglist";
	}
	

}
