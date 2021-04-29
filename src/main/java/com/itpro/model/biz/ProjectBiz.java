package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.ProjectDto;

public interface ProjectBiz {

	
	public int insertlist(List<ProjectDto> projectList);
	public int deletelist();
	public List<ProjectDto> selectList();
}
