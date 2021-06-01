package com.itpro.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.ResumeBiz;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.resume.ResumeDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CompanyController {
	

	@Autowired
	private ResumeBiz biz;
	
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

	@RequestMapping(value="/resumesubmitform.do")
	public String resumesubmitform(HttpSession session, Model model) {
		log.info("resumesubmitform.do");

		int m_no = 0;

		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		List<ResumeDto> resumeList = biz.resumeList(m_no);
		model.addAttribute("resumeList", resumeList);
		return "resume/resume_submit";
	}	
}
