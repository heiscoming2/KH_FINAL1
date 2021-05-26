package com.itpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.BoardCategoryBiz;
import com.itpro.model.biz.ManageMemberBiz;
import com.itpro.model.biz.ReportBiz;
import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.admin.ManageMemberDto_com;
import com.itpro.model.dto.board.BoardCategoryDto;
import com.itpro.model.dto.board.BoardDto;
import com.itpro.model.dto.report.ReportDto;

@Controller
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	ManageMemberBiz biz;
	
	@Autowired
	ReportBiz rebiz;
	
	@Autowired
	BoardBiz boardbiz;
	
	@Autowired
	BoardCategoryBiz categorybiz;
	
	////////////////////////////회원 관리 part/////////////////////////////////////////////////
	
	
	////개인회원 + 관리자//////////////////////
	@RequestMapping("/member_list.do")
	public String member_list(Model model ) {
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
	
	@RequestMapping(value="/member_update.do")
	public String update(ManageMemberDto dto) {
		logger.info("member_update");
		int res = biz.update(dto);
		
		if(res>0) {
			return "redirect:member_detail.do?m_no="+dto.getM_no();
		}else {
			return "redirect:updateform.do?m_no="+dto.getM_no();
		}
	}
		
		
	//// 기업회원 //////////////////////
		@RequestMapping("/member_list_com.do")
		public String member_list_com(Model model ) {
			logger.info("select list_com");
			model.addAttribute("list_com",biz.selectList_com());
			
			
			return "admin/member_list_com";
		}
		
		@RequestMapping(value="/member_detail_com.do")
		public String member_detail_com(Model model, int m_no) {
			
			logger.info("member_detail_com" );
			
			System.out.println("biz에 오는 값");
			ManageMemberDto_com manageMemberDto_com = biz.selectOne_com(m_no);
			model.addAttribute("dto", manageMemberDto_com);
			
			logger.info(manageMemberDto_com.getM_nickname());
			

			return "admin/member_detail_com";
		}
		
		@RequestMapping(value="/member_updateform_com.do")
		public String member_updateform_com(Model model, int m_no) {
			
			logger.info("member_updateform_com");
			
			model.addAttribute("dto", biz.selectOne_com(m_no));
			return "admin/member_update_com";
		}
		
		@RequestMapping(value="/member_update_com.do")
		public String update_com(ManageMemberDto_com dto) {
			logger.info("member_update_com");
			int res_com = biz.update_com(dto);
			
			if(res_com>0) {
				return "redirect:member_detail_com.do?m_no="+dto.getM_no();
			}else {
				return "redirect:member_updateform_com.do?m_no="+dto.getM_no();
			}
		
		}
		
	

		
		////////////////////////////신고 part//////////////////////////////////////
	
	//insert 입력페이지로 이동
	@RequestMapping(value="/reportinsertform.do")
	public String insertreportform(Model model, @RequestParam("bd_no") int bd_no) {
		logger.info("reportinsertform");
		
		ReportDto dto = rebiz.select2(bd_no);
		
		model.addAttribute("dto", dto);
		
		return "report/reportinsertform";
	}

	
	//insert에서 값이 넘어옴.성공여부에 따라 alert 메시지를 다르게 나오면 될 것 같음. 
	@RequestMapping(value="/report_insert.do")
	public String insertRes(ReportDto dto,HttpServletResponse response) throws IOException {
		logger.info("reportinsert");
		logger.info(dto.toString());
		int res= rebiz.insert(dto);
		System.out.println("res: " + res);
		if(res>0) {
			
			System.out.println("res: " + res);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('신고완료');");
			out.print("self.close();");
			out.print("</script>");
			
			return null;
		}else {
			return "redirect:reportinsertform.do";
		}
		
	}
	//report list
	@RequestMapping(value="/reportlist.do")
	public String report_list(Model model) {
		
		//게시물 수 반환
		//int reportcnt = rebiz.getReportCnt();
			
		
		logger.info("reportlist");
		List<ReportDto> list = rebiz.selectList();
		model.addAttribute("list",list);
		//model.addAttribute("cnt",reportcnt);
		//System.out.println("report:"+reportcnt);
		
		return "report/reportlist";
	}
	
	//report detail
	@RequestMapping(value="/reportdetail.do")
	public String reportdetail(Model model, int bd_no) {
		logger.info("REPORT DETAIL");
		
		model.addAttribute("dto", rebiz.selectOne(bd_no));
		
		return "report/reportdetail";
	}
	
	@RequestMapping(value = "/category")
	public @ResponseBody String getCategory() {
		
		List<BoardCategoryDto> category=categorybiz.selectList(); 
		
		return new Gson().toJson(category);
	
	}
	
	
	
	/*	
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
