package com.itpro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.util.ClientInfo;
import com.itpro.util.PageProcessing;

@Controller
public class ProjectController {

private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectBiz projectBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@RequestMapping(value="/projectlist.do")
	public String projectList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		//페이징을 위해 총 게시물수 count
		int projectListCnt = projectBiz.getProjectListCnt();
		
		//게시물수와 선택페이지에 해당하는 페이지 정보값을 dto로 담아둔다.
		PageProcessing pageProcessing = new PageProcessing(projectListCnt,page);
		
		logger.info(Integer.toString(pageProcessing.getCurPage()));
		logger.info(Integer.toString(pageProcessing.getCurRange()));
		logger.info(Integer.toString(pageProcessing.getEndPage()));
		logger.info(Integer.toString(pageProcessing.getPageSize()));
		logger.info(Integer.toString(pageProcessing.getEndIndex()));
		
		//리스트를 select 해오는데, startindex와 endindex를 매개변수로 주어 받아온다.
		//(이 부분은 나중에 PageProcessing 클래스에서 map을 바로 리턴받는 형태로 변경하는게 나을듯)
		Map<String,Object> projectPageMap = new HashMap<String,Object>();
		projectPageMap.put("start", pageProcessing.getStartIndex());
		projectPageMap.put("end", pageProcessing.getEndIndex());
		List<ProjectListDto> projectList = projectBiz.selectList(projectPageMap);
		
		//페이징 처리 model에 담아줌 (_page.jspf에서 받아서 사용됨)
		model.addAttribute("pageProcessing",pageProcessing);
		//프로젝트 글 목록을 받아 model에 담아준다.
		model.addAttribute("projectList",projectList);
		
//		List<ProjectListDto> projectList = projectBiz.selectList(null);
//		model.addAttribute("projectList", projectList);
		
		return "project/projectlist";
	}
	
	@RequestMapping(value="/projectinsertform.do")
	public String projectInsertForm() {
		logger.info("PROJECT INSERT FORM");
		return "project/projectinsertform";
	}
	
	@RequestMapping(value="/projectinsert.do")
	public String projectInsert(HttpServletRequest request, HttpServletResponse response, ProjectInsertDto projectDto) {
		projectDto.setBd_writerip(new ClientInfo().getClientIp(request));
		logger.info("PROJECT INSERT : "+projectDto.getBd_title());
		
		projectBiz.projectInsert(projectDto);
		return "redirect:projectlist.do";
	}	
	
	
	@RequestMapping(value="/projectdetail.do")
	public String projectDetail(Model model, @RequestParam(value="bd_no") int bd_no) {
		logger.info("PROJECT DETAIL");
		
		ProjectDetailDto projectDetailDto = projectBiz.selectOne(bd_no);
		model.addAttribute("projectDetailDto",projectDetailDto);
		//댓글 list받아와 model에 담아준다.
		List<ReplyListDto> replyListDto = replyBiz.selectList(bd_no);
		model.addAttribute("replyListDto",replyListDto);
		
		//댓글 총 갯수를 받아와 model에 담아준다.
		int replyCnt = replyBiz.replyCnt(bd_no);
		model.addAttribute("replyCnt",replyCnt);
		
		return "project/projectdetail";
	}	
	
	@RequestMapping(value="/projectupdate.do")
	public String projectUpdate(Model model) {
		
		logger.info("PROJECT UPDATE");
		return "project/projectupdate";
	}
	
	
	@RequestMapping(value="/projectdelete.do")
	public String projectDelete(Model model, int bd_no) {
		logger.info("PROJECT DELETE");
		int projectDeleteRes = projectBiz.delete(bd_no);
		
		//나중에 int값으로 실패시 alert 처리
		return "redirect:projectlist.do";
	}
	
	
}
