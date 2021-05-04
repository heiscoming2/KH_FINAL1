package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.project.ProjectListDto;

public interface PortfolioDao {

	
	String NAMESPACE = "Project.";

	public List<ProjectListDto> selectList();
	public int insertlist(List<ProjectListDto> projectList);
	public int deletelist();
}
