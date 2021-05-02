package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.ProjectDto;
import com.itpro.model.dto.StudyDto;

public interface ProjectBiz {

	public List<ProjectDto> selectList();
	public ProjectDto selectOne(int bd_no);
	public int insert(ProjectDto projectDto);
	public int delete();
	public int update();

}
