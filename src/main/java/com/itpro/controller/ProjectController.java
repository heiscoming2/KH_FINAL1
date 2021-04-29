package com.itpro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.dto.ProjectDto;

@Controller
public class ProjectController {

private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectBiz ProjectBizImpl;
	
	@RequestMapping(value="/projectlist.do")
	public String projectList(Model model) {
		
		List<ProjectDto> projectList = ProjectBizImpl.selectList();
		model.addAttribute("projectList", projectList);
		return "project/projectlist";
	}
	
	
}
