package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.project.ProjectUpdateDto;
import com.itpro.model.dto.study.StudyUpdateDto;

public interface ProjectBiz {

	public List<ProjectListDto> selectList(Map<String, Object> projectPageMap);
	public ProjectDetailDto selectOne(int bd_no);
	public int projectInsert(ProjectInsertDto projectDto);
	public int update(ProjectUpdateDto projectDto);
	public int delete(int bd_no);
	public int getProjectListCnt();
	public void like_cnt_up(int bd_no);
	public void like_cnt_down(int bd_no);
	public ProjectDetailDto read(int bd_no);
	public int update(ProjectUpdateDto projectUpdateDto, BoardUpdateDto boardUpdateDto);
	

}
