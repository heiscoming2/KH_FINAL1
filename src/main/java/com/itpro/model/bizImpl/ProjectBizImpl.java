package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.dao.ProjectDao;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.project.ProjectUpdateDto;

@Service
public class ProjectBizImpl implements ProjectBiz{

	@Autowired
	private ProjectDao projectDao;

	@Override
	public List<ProjectListDto> selectList(Map<String, Object> projectPageMap) {
		return projectDao.selectList(projectPageMap);
	}

	@Override
	public ProjectDetailDto selectOne(int bd_no) {
		return projectDao.selectOne(bd_no);
	}

	@Override
	public int projectInsert(ProjectInsertDto projectDto) {
		return projectDao.projectInsert(projectDto);
	}

	@Override
	public int update(ProjectUpdateDto projectDto) {
		int projectUpdateRes = projectDao.update(projectDto);
		return projectUpdateRes;
	}

	@Override
	public int delete(int bd_no) {
		int projectDeleteRes = projectDao.delete(bd_no);
		return projectDeleteRes;
	}

	@Override
	public int getProjectListCnt() {
		// TODO Auto-generated method stub
		return projectDao.getProjectListCnt();
	}

	@Override
	public void like_cnt_up(int bd_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void like_cnt_down(int bd_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProjectDetailDto read(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
