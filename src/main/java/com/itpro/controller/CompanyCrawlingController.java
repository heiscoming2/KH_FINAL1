package com.itpro.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.CompanyCrawlingBiz;
import com.itpro.model.bizImpl.CompanyCrawlingBizImpl;
import com.itpro.model.dto.CompanyCrawlingDto;
import com.itpro.util.CompanyCrawler;

@Controller
public class CompanyCrawlingController {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyCrawlingController.class);
	
	@Autowired
	private CompanyCrawlingBiz companyCrawlingBizImpl;
	
	@RequestMapping(value="/companycrawlinglist.do")
	public String companyCrawlingList(Model model) {
		
		List<CompanyCrawlingDto> companyCrawlingList = companyCrawlingBizImpl.selectList();
		model.addAttribute("companyCrawlingList",companyCrawlingList);
		return "companycrawling/companycrawlinglist";
	}
	
	@RequestMapping(value="/companycrawlingupdate.do")
	public String companyCrawlingInsert(Model model) {
		
		CompanyCrawler companyCralwer = new CompanyCrawler();
		List<CompanyCrawlingDto> companyCrawlingList = companyCralwer.getCompanyCrawlingList();
		model.addAttribute("companyCrawlingList",companyCrawlingList);
		return "companycrawling/companycrawlinglist";
	}
	
	@RequestMapping(value="/companycrawlingdelete.do")
	public String companyCrawlingDelete() {
		
		int res = companyCrawlingBizImpl.deletelist();
		return "companycrawling/companycrawlinglist";
	}
	

}
