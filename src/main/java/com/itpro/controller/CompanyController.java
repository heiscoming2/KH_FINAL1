package com.itpro.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CompanyController {

	@RequestMapping(value="/companylist.do")
	public String companyList() {
		log.info("companylist.do");
		return "company/companylist";
		
	}	
		
	@RequestMapping(value="/companydetail.do")
	public String companyDetail() {
		log.info("companydetail.do");
		return "company/companydetail";
		
	}
}
