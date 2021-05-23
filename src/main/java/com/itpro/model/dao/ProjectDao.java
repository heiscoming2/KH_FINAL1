package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.board.BoardInsertDto;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.project.ProjectUpdateDto;

public interface ProjectDao {

	
	String NAMESPACE = "Project.";

	public List<ProjectListDto> selectList(Map<String, Object> projectPageMap);
	public List<ProjectDetailDto> selectOne(int bd_no);
	public List<ProjectInsertDto> projectInsert(List<ProjectInsertDto> projectDto, BoardInsertDto boardInsertDto);
	public int update(ProjectUpdateDto projectDto);
	public int delete(int bd_no);
	public int getProjectListCnt();
	public int imageuploadupdate(int pro_no, String pro_file);
	
//	public List<ProjectListDto> selectCategoryList(Map<String, Object> projcetCategoryMap);
	}