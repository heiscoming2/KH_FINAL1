package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.dao.ProjectDao;
import com.itpro.model.dto.CompanyCrawlingDto;
import com.itpro.model.dto.ProjectDto;

@Service
public class ProjectBizImpl implements ProjectBiz{

	@Autowired
	private ProjectDao ProjectDaoImpl;
	
	@Override
	@Transactional
	public int insertlist(List<ProjectDto> projectList) {
		deletelist();
		return ProjectDaoImpl.insertlist(projectList);
	}

	@Override
	public int deletelist() {

		return ProjectDaoImpl.deletelist();
	}

	@Override
	public List<ProjectDto> selectList() {
		List<ProjectDto> projectList = ProjectDaoImpl.selectList();
		return projectList;
	}
	

}
