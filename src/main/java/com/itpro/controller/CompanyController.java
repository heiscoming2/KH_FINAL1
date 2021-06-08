package com.itpro.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itpro.model.biz.CompanyBiz;
import com.itpro.model.biz.ResumeBiz;
import com.itpro.model.dto.company.CompanyResumeDto;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.util.JavaScriptResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CompanyController {
	

	@Autowired
	private ResumeBiz resumeBiz;
	
	@Autowired
	private CompanyBiz companyBiz;
	
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

		List<ResumeDto> resumeList = resumeBiz.resumeList(m_no);
		model.addAttribute("resumeList", resumeList);
		return "resume/resume_submitform";
	}	
	
	@RequestMapping(value="/resumesubmit.do")
	public String resumesubmit(@RequestParam("bd_no") int bd_no,@RequestParam("r_no") int r_no,HttpServletResponse response) throws IOException {
		log.info("resumesubmit.do");
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("bd_no", bd_no);
		map.put("r_no", r_no);
		int res = companyBiz.insert(map);
		if(res==1) {
			new JavaScriptResponse().jsResponse(response, "이력서를 제출 하였습니다.", "resumesubmitform.do");
		} else {
			new JavaScriptResponse().jsResponse(response, "이미 제출한 이력서가 존재합니다.", "resumesubmitform.do");
		}
		return null;
	}
	
	@RequestMapping(value="/companyresumelist.do")
	public String companyresumelist(@RequestParam("m_no") int m_no,Model model) throws IOException {
		log.info("companyresumelist.do");
		List<CompanyResumeDto> CompanyResumeList = companyBiz.selectCompanyResumeList(m_no);
		model.addAttribute("CompanyResumeList",CompanyResumeList);
		return "company/companyresumelist";
	}
	
	@RequestMapping(value="/companyapplicationstatuschange.do")
	@ResponseBody
	public boolean companyApplicationStatusChange(@RequestParam("r_no") int r_no, 
			@RequestParam("bd_no") int bd_no, 
			@RequestParam("ca_status") char ca_status,
			Model model) throws IOException {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("r_no", r_no);
		map.put("bd_no", bd_no);
		map.put("ca_status", ca_status);
		int tmp = companyBiz.updateStatusChange(map);
		return tmp>0?true:false;
	}	
	
	
}











