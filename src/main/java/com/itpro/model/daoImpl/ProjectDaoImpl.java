package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ProjectDao;
import com.itpro.model.dto.portfolio.PortfolioDto;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ProjectListDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDetailDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int projectInsert(ProjectInsertDto projectDto) {
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
