package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ProjectDao;
import com.itpro.model.dto.PortfolioDto;
import com.itpro.model.dto.ProjectDto;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<PortfolioDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertlist(List<PortfolioDto> portfolioList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletelist() {
		// TODO Auto-generated method stub
		return 0;
	}


}
