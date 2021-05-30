package com.itpro.model.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.itpro.model.dto.board.BoardInsertDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.project.ProjectUpdateDto;
import com.itpro.model.dto.study.StudyUpdateDto;

public interface ProjectBiz {

	public List<ProjectListDto> selectList(Map<String, Object> projectPageMap);
	public List<ProjectDetailDto> selectOne(int bd_no);
	public ProjectDetailDto projectSelectOne(int bd_no); //reply 때문에 하나 생성
	public List<ProjectInsertDto>  projectInsert(ArrayList<ProjectInsertDto> projectDto, BoardInsertDto boardInsertDto);
	public int update(ProjectUpdateDto projectDto);
	public int delete(int bd_no);
	public int getProjectListCnt();
	public int update(ProjectUpdateDto projectUpdateDto, BoardUpdateDto boardUpdateDto);
//	public List<ProjectListDto> selectCategoryList(Map<String, Object> projcetCategoryMap);
	public int imageuploadupdate(MultipartFile fileName, int parseInt);
	public String selectDetail(int bd_no);
	public List<ProjectInsertDto> projectUpdate(ArrayList<ProjectInsertDto> projectDtoList, BoardUpdateDto boardupdateDto);
	public int imagePathUpdate(int pro_no, String img_path);

}
