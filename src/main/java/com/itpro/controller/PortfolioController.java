package com.itpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.PortfolioBiz;
import com.itpro.model.dto.PortfolioDto;
import com.itpro.util.ClientInfo;

@Controller
public class PortfolioController {

private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);
	
	@Autowired
	private PortfolioBiz portfolioBiz;
	
	@RequestMapping(value="/portfoliolist.do")
	public String portfolioList(Model model) {
		
		List<PortfolioDto> portfolioList = portfolioBiz.selectList();
		model.addAttribute("portfolioList", portfolioList);
		return "portfolio/portfoliolist";
	}
	
	@RequestMapping(value="/portfolioinsertform.do")
	public String portfolioInsertForm() {
		logger.info("PORTFOLIO INSERT FORM");
		return "portfolio/portfolioinsertform";
	}
	
	@RequestMapping(value="/portfolioinsert.do")
	public String portfolioInsert(HttpServletRequest request, PortfolioDto portfolioDto) {
		logger.info("PORTFOLIO INSERT");
		portfolioDto.setBd_writerip(new ClientInfo().getClientIp(request));
		portfolioBiz.insert(portfolioDto);
		return "portfolio/portfolioinsertform";
	}	
	
	
	@RequestMapping(value="/portfoliodetail.do")
	public String portfolioDetail(HttpServletRequest request, PortfolioDto portfolioDto) {
		logger.info("PORTFOLIO DETAIL");
		return "portfolioboard/portfoliodetail";
	}	
	
}
