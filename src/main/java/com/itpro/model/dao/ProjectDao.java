package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.PortfolioDto;

public interface ProjectDao {

	
	String NAMESPACE = "Portfolio.";

	public List<PortfolioDto> selectList();
	public int insertlist(List<PortfolioDto> portfolioList);
	public int deletelist();
}
