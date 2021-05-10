package com.itpro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.ManageMemberBiz;
import com.itpro.model.biz.ReportBiz;
import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.report.ReportDto;

@Controller
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	ManageMemberBiz biz;
	ReportBiz rebiz;
	
	
	//�쉶�썝愿�由� 而⑦듃濡ㅻ윭
	@RequestMapping("/member_list.do")
	public String member_list(Model model) {
		logger.info("select list");

		model.addAttribute("list",biz.selectList());
		
		
		return "admin/member_list";
	}
	
	@RequestMapping(value="/member_detail.do")
	public String member_detail(Model model, int m_no) {
		
		logger.info("member_detail");
		
		model.addAttribute("dto", biz.selectOne(m_no));
		return "admin/member_detail";
	}
	
	@RequestMapping(value="/member_updateform.do")
	public String member_updateform(Model model, int m_no) {
		
		logger.info("member_updateform");
		
		model.addAttribute("dto", biz.selectOne(m_no));
		return "admin/member_update";
	}
	
	@RequestMapping(value="/MemberManage_update.do")
	public String update(ManageMemberDto dto) {
		logger.info("MemberManage_update");
		int res = biz.update(dto);
		
		if(res>0) {
			return "redirect:member_detail.do?myno="+dto.getM_no();
		}else {
			return "redirect:updateform.do?myno="+dto.getM_no();
		}
		
	}
	
	//insert 입력페이지로 이동
	@RequestMapping(value="/report_insertform.do")
	public String insertform(Model model, int report_no) {
		logger.info("report_insertform");
		
		model.addAttribute("dto", rebiz.selectOne(report_no));
		return "report_insert";
	}

	
	//insert에서 값이 넘어옴.
	@RequestMapping(value="/report_insert.do")
	public String insertRes(ReportDto dto) {
		logger.info("report_insert");
		
		int res= rebiz.insert(dto);
		
		if(res>0) {
			return "redirect:report_list.do";
		}else {
			return "redirect:report_insertform.do";
		}
		
	}
	//report list
	@RequestMapping(value="/report_list.do")
	public String report_list(Model model) {
		logger.info("report_list");
		
		model.addAttribute("list",rebiz.selectList());
		
		return "admin/report_list";
	}
	
	/*	
	//�씠�젰�꽌 愿��젴 而⑦듃濡ㅻ윭
	@RequestMapping(value="/resume_list.do")
	public String resumeList() {
		logger.info("RESUEM LIST");
		
		return "login_join/resume_list";
	}
	
	@RequestMapping(value="/resume_form.do")
	public String resumeForm() {
		logger.info("RESUEM FORM");
		
		return "login_join/resume_form";
	}
	
	@RequestMapping(value="/resume_detail.do")
	public String resumeDetail() {
		logger.info("RESUEM DETIAL");
		
		return "login_join/resume_detail";
	}
	
	@RequestMapping(value="/resume_update.do")
	public String resumeUpdate() {
		logger.info("RESUEM UPDATE");
		
		return "login_join/resume_update";
	}
	
	
	//履쎌� 愿��젴 而⑦듃濡ㅻ윭
	@RequestMapping(value="/note_sendlist.do")
	public String noteSendList() {
		logger.info("NOTE SEND LIST");
		
		return "login_join/note_sendlist";
	}
	@RequestMapping(value="/note_receivelist.do")
	public String noteReceiveList() {
		logger.info("NOTE RECEIVE LIST");
		
		return "login_join/note_receivelist";
	}
	
	//
	@RequestMapping(value="/post_list.do")
	public String postList() {
		logger.info("NOTE LIST");
		
		return "login_join/post_list";
	}*/
}
