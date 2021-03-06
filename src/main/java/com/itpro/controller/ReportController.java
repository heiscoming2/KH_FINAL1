package com.itpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.BoardCategoryBiz;
import com.itpro.model.biz.ManageMemberBiz;
import com.itpro.model.biz.ReportBiz;
import com.itpro.model.biz.ReportReplyBiz;
import com.itpro.model.dto.report.ReportDto;
import com.itpro.model.dto.report.ReportReplyDto;

@Controller
public class ReportController {
	private Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	ManageMemberBiz biz;
	
	@Autowired
	ReportBiz rebiz;
	
	@Autowired
	ReportReplyBiz rerebiz;
	
	@Autowired
	BoardBiz boardbiz;
	
	@Autowired
	BoardCategoryBiz categorybiz;
	
	
		
		////////////////////////////신고 part//////////////////////////////////////
	
        ////////////////신고 part_게시판//////////////////////
	
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
		
		//System.out.println("report:"+reportcnt);
		
		return "report/reportlist";
	}
	
	//report detail = selectOne
	@RequestMapping(value="/reportdetail.do")
	public String reportdetail(Model model,@RequestParam("bd_no") int bd_no) {
		logger.info("REPORT DETAIL");
		model.addAttribute("list2", rebiz.selectList2(bd_no));
		
		System.out.println("reportlist2 : "+model);
		
		return "report/reportdetail";
	}
	
	//report delete
	@RequestMapping(value="/reportdelete.do")
	public String reportDelete(Model model, int report_no,HttpServletResponse response) throws IOException {
		logger.info("REPORT DELETE");
		int reportDeleteRes = rebiz.delete(report_no);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('삭제 되었습니다.');");
		out.print("location.href='reportlist.do';");
		out.print("</script>");
		return null;
		
		}
	
	//report multi delete	
	@RequestMapping(value="/reportmultidelete.do")
	public String reportMultiDelete(Model model, int report_no,HttpServletResponse response, HttpServletRequest request) throws IOException {
		logger.info("REPORT MULTI DELETE");
		
		String[] chks = request.getParameterValues("chk");
		int res= rebiz.multiDelete(chks);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(res==chks.length){
	
			out.print("<script>");
			out.print("alert('삭제 되었습니다.');");
			out.print("location.href='reportlist.do';");
			out.print("</script>");
			return null;
	
		}else{
			out.print("<script>");
			out.print("alert('삭제실패 하였습니다.');");
			out.print("location.href='reportlist.do';");
			out.print("</script>");
			return null;
	
		}		
	}
	
	
	
	
	
	
	////////////////신고 part_댓글//////////////////////
	
	@RequestMapping(value="/reportreplyinsertform.do")
	public String insertreportreplyform(Model model, @RequestParam("re_no") int re_no) {
		logger.info("reportinsertform");
		logger.toString();
		ReportReplyDto dto = rerebiz.select2(re_no);
		
		model.addAttribute("dto", dto);
		
		return "report/reportreplyinsertform";
	}

	
	//insert에서 값이 넘어옴.성공여부에 따라 alert 메시지를 다르게 나오면 될 것 같음. 
	@RequestMapping(value="/reportreply_insert.do")
	public String insertRes(ReportReplyDto dto,HttpServletResponse response) throws IOException {
		logger.info("reportinsert");
		logger.info(dto.toString());
		
		
		int res= rerebiz.insert(dto);
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
			return "redirect:reportreplyinsertform.do";
		}
		
	}
	//reportreply list
	@RequestMapping(value="/reportreplylist.do")
	public String reportreply_list(Model model) {
		
		//게시물 수 반환
		//int reportcnt = rebiz.getReportCnt();
			
		
		logger.info("reportreplylist");
		List<ReportReplyDto> list = rerebiz.selectList();
		int count =rerebiz.getReportReplyCnt();
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		//System.out.println("report:"+reportcnt);
		
		return "report/reportreplylist";
	}
	
	//reportreply detail
	@RequestMapping(value="/reportreplydetail.do")
	public String reportreplydetail(Model model, @RequestParam("re_no") int re_no) {
		logger.info("REPORT reply DETAIL");
		
		model.addAttribute("list2", rerebiz.selectList2(re_no));
		
		return "report/reportreplydetail";
	}
	
	//reportreply delete
	@RequestMapping(value="/reportreplydelete.do")
	public String reportreplyDelete(Model model, int report_reply_no,HttpServletResponse response) throws IOException {
		logger.info("REPORT REPLY DELETE");
		int reportreplyDeleteRes = rerebiz.delete(report_reply_no);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('삭제 되었습니다.');");
		out.print("location.href='reportreplylist.do';");
		out.print("</script>");
		return null;
	}
	
	
	
	
	
	
	
	
	
}
