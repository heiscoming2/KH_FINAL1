package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.project.ProjectUpdateDto;

public interface ProjectBiz {

	public List<ProjectListDto> selectList(Map<String, Object> projectPageMap);
	public ProjectDetailDto selectOne(int bd_no);
	public int projectInsert(ProjectInsertDto projectDto);
	public int update(ProjectUpdateDto projectDto);
	public int delete(int bd_no);
	

}
