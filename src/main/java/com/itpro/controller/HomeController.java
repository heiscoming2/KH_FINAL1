package com.itpro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/main.do")
	public String getMain(Model model,HttpServletRequest request) {
		logger.info(request.getSession().getServletContext().getRealPath("/"));
		logger.info("main.do");
		return "main";
	}
	
	
}
