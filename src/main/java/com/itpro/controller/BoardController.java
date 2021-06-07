package com.itpro.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itpro.util.JavaScriptResponse;

@Controller
public class BoardController {
	
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
	


}
