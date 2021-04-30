package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ProjectDao;
import com.itpro.model.dto.ProjectDto;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ProjectDto> selectList() {
		List<ProjectDto> projectList = sqlSession.selectList(NAMESPACE+"selectList");
		return projectList;
	}

	@Override
	public int insertlist(List<ProjectDto> projectList) {
		int res = sqlSession.insert(NAMESPACE+"insertlist", projectList);
		return res;
	}

	@Override
	public int deletelist() {
		int res = sqlSession.delete(NAMESPACE+"deletelist");
		return res;
	}

}
