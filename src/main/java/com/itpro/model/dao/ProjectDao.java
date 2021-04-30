package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.ProjectDto;

public interface ProjectDao {

	
	String NAMESPACE = "Project.";

	public List<ProjectDto> selectList();
	public int insertlist(List<ProjectDto> projectList);
	public int deletelist();
}
