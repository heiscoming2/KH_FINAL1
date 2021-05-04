package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.PortfolioDao;
import com.itpro.model.dto.project.ProjectListDto;

@Repository
public class PortfolioDaoImpl implements PortfolioDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ProjectListDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertlist(List<ProjectListDto> projectList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletelist() {
		// TODO Auto-generated method stub
		return 0;
	}



}
