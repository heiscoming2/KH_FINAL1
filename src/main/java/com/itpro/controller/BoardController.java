package com.itpro.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itpro.model.biz.BoardBiz;
import com.itpro.util.JavaScriptResponse;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardBiz boardBiz;
	
	@RequestMapping(value="/boarddetail.do")
	public String boardDetail(int bc_code, int bd_no,int m_no, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");		
		
		switch(bc_code) {
		
		case 1 : return "redirect:projectdetail.do?bd_no="+bd_no;
		case 2 : return "redirect:qnadetail.do?bd_no="+bd_no;
		case 3 : return "redirect:studydetail.do?bd_no="+bd_no;
		case 4 : new JavaScriptResponse().jsResponse(response, "잘못된 접근입니다.", "main.do"); return null;
		case 5 : return "redirect:noticedetail.do?bd_no="+bd_no;
		case 6 : new JavaScriptResponse().jsResponse(response, "잘못된 접근입니다.", "main.do"); return null;
		case 7 : return "redirect:portfoliodetail.do?bd_no="+bd_no+"&m_no="+m_no;
		default : new JavaScriptResponse().jsResponse(response, "잘못된 접근입니다.", "main.do"); return null;
		
		}
		
	}
	
	//멀티 딜리트
	@RequestMapping(value = "/muldel.do")
	@ResponseBody
	public int muldel(@RequestBody List<Map<String,Integer>> muldelarr) {
		log.info("muldel");
		int res = boardBiz.muldel(muldelarr);
		return res;
	}
	

}
