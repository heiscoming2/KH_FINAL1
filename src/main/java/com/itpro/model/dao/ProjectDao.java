package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;

public interface ProjectDao {

	
	String NAMESPACE = "Project.";

	public List<ProjectListDto> selectList();
	public ProjectDetailDto selectOne(int bd_no);
	public int projectInsert(ProjectInsertDto projectDto);
	public int delete();
	public int update();
	
	
}
