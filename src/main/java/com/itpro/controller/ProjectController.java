package com.itpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.util.ClientInfo;

@Controller
public class ProjectController {

private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectBiz projectBiz;
	
	@RequestMapping(value="/projectlist.do")
	public String projectList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		List<ProjectListDto> projectList = projectBiz.selectList(null);
		model.addAttribute("projectList", projectList);
		return "project/projectlist";
	}
	
	@RequestMapping(value="/projectinsertform.do")
	public String projectInsertForm() {
		logger.info("PROJECT INSERT FORM");
		return "project/projectinsertform";
	}
	
	@RequestMapping(value="/projectinsert.do")
	public String projectInsert(HttpServletRequest request, ProjectInsertDto projectDto) {
		logger.info("PROJECT INSERT");
		projectDto.setBd_writerip(new ClientInfo().getClientIp(request));
		projectBiz.projectInsert(projectDto);
		return "redirect:projectlist.do";
	}	
	
	
	@RequestMapping(value="/projectdetail.do")
	public String projectDetail(HttpServletRequest request, ProjectDetailDto projectDto) {
		logger.info("PROJECT DETAIL");
		return "project/projectdetail";
	}	
	
	@RequestMapping(value="/projectupdate.do")
	public String projectUpdate(Model model) {
		
		logger.info("PROJECT UPDATE");
		return "project/projectupdate";
	}
	
}
