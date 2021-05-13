package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.project.ProjectUpdateDto;
import com.itpro.model.dto.study.StudySearchDto;
import com.itpro.model.dto.study.StudyUpdateDto;

public interface ProjectDao {

	
	String NAMESPACE = "Project.";

	public List<ProjectListDto> selectList(Map<String, Object> projectPageMap);
	public ProjectDetailDto selectOne(int bd_no);
	public int projectInsert(ProjectInsertDto projectDto);
	public int update(ProjectUpdateDto projectDto);
	public int delete(int bd_no);
	public int getProjectListCnt();
	public static ProjectDetailDto read(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
