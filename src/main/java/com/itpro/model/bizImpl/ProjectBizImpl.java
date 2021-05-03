package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.dao.ProjectDao;
import com.itpro.model.dto.ProjectDto;
import com.itpro.model.dto.crawling.CompanyCrawlingDto;

@Service
public class ProjectBizImpl implements ProjectBiz{

	@Autowired
	private ProjectDao ProjectDaoImpl;

	
	@Override
	public List<ProjectDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ProjectDto projectDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}


}
