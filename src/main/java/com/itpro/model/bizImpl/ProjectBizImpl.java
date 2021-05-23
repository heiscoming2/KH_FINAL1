package com.itpro.model.bizImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.ProjectDao;
import com.itpro.model.dto.board.BoardInsertDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.project.ProjectUpdateDto;

@Service
public class ProjectBizImpl implements ProjectBiz{

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<ProjectListDto> selectList(Map<String, Object> projectPageMap) {
		return projectDao.selectList(projectPageMap);
	}

	@Override
	public List<ProjectDetailDto> selectOne(int bd_no) {
		
		return projectDao.selectOne(bd_no);
	}

	@Override
	public List<ProjectInsertDto>  projectInsert(ArrayList<ProjectInsertDto> projectDto, BoardInsertDto boardInsertDto) {
		
		return projectDao.projectInsert(projectDto, boardInsertDto);
	}

	@Override
	public int update(ProjectUpdateDto projectDto) {
		int projectUpdateRes = projectDao.update(projectDto);
		return projectUpdateRes;
	}

	@Override
	public int delete(int bd_no) {
		int Deleteres = 0;
		int projectDeleteRes = projectDao.delete(bd_no);
		int boardDeleteRes = boardDao.delete(bd_no);
		if(projectDeleteRes>0 && boardDeleteRes>0) {
			Deleteres = 1;
		}
		return Deleteres; 
	}

	@Override
	public int getProjectListCnt() {
		// TODO Auto-generated method stub
		return projectDao.getProjectListCnt();
	}


	@Override
	public int update(ProjectUpdateDto projectUpdateDto, BoardUpdateDto boardUpdateDto) {
		int res = 0;
		int projectUpdateRes = projectDao.update(projectUpdateDto);
		int boardUpdateRes = boardDao.update(boardUpdateDto);
		if(projectUpdateRes>0 && boardUpdateRes>0) {
			res = 1;
		}
		return res; 
	}

	@Override
	public int imageuploadupdate(int pro_no, String pro_file) {
		
		return projectDao.imageuploadupdate(pro_no, pro_file);
	}

//	@Override
//	public List<ProjectListDto> selectCategoryList(Map<String, Object> projcetCategoryMap) {
//		return projectDao.selectCategoryList(projcetCategoryMap);
//	}


	
	

}
