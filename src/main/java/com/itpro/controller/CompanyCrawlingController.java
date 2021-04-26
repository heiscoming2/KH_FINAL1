package com.itpro.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyCrawlingController {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyCrawlingController.class);
	
	@RequestMapping(value="/companycrawlinglist.do")
	public String CompanyCrawlingList() {
		return "companycrawling/companycrawlinglist";
	}
	

}
