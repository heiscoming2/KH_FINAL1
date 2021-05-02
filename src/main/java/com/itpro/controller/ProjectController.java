package com.itpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.dto.ProjectDto;
import com.itpro.util.ClientInfo;

@Controller
public class ProjectController {

private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectBiz projectBiz;
	
	@RequestMapping(value="/projectlist.do")
	public String projectList(Model model) {
		
		List<ProjectDto> projectList = projectBiz.selectList();
		model.addAttribute("projectList", projectList);
		return "project/projectlist";
	}
	
	@RequestMapping(value="/projectinsertform.do")
	public String projectInsertForm() {
		logger.info("PROJECT INSERT FORM");
		return "project/projectinsertform";
	}
	
	@RequestMapping(value="/projectinsert.do")
	public String projectInsert(HttpServletRequest request, ProjectDto projectDto) {
		logger.info("PROJECT INSERT");
		projectDto.setBd_writerip(new ClientInfo().getClientIp(request));
		projectBiz.insert(projectDto);
		return "project/projectinsertform";
	}	
	
	
	@RequestMapping(value="/projectdetail.do")
	public String projectDetail(HttpServletRequest request, ProjectDto projectDto) {
		logger.info("PROJECT DETAIL");
		return "projectboard/projectdetail";
	}	
	
}
