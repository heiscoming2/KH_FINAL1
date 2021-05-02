package com.itpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.QnaBiz;
import com.itpro.model.dto.QnaDto;
import com.itpro.util.ClientInfo;

@Controller
public class QnaController {

private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	private QnaBiz qnaBiz;
	
	@RequestMapping(value="/qnalist.do")
	public String qnaList(Model model) {
		
		List<QnaDto> qnaList = qnaBiz.selectList();
		model.addAttribute("qnaList", qnaList);
		return "qna/qnalist";
	}
	
	@RequestMapping(value="/qnainsertform.do")
	public String qnaInsertForm() {
		logger.info("QNA INSERT FORM");
		return "qna/qnainsertform";
	}
	
	@RequestMapping(value="/qnainsert.do")
	public String qnaInsert(HttpServletRequest request, QnaDto qnaDto) {
		logger.info("QNA INSERT");
		qnaDto.setBd_writerip(new ClientInfo().getClientIp(request));
		qnaBiz.insert(qnaDto);
		return "qna/qnainsertform";
	}	
	
	
	@RequestMapping(value="/qnadetail.do")
	public String qnaDetail(HttpServletRequest request, QnaDto qnaDto) {
		logger.info("QNA DETAIL");
		return "qnaboard/qnadetail";
	}	
	
}
