package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.portfolio.PortfolioDetailDto;
import com.itpro.model.dto.portfolio.PortfolioInsertDto;
import com.itpro.model.dto.portfolio.PortfolioListDto;
import com.itpro.model.dto.portfolio.PortfolioUpdateDto;
import com.itpro.model.dto.project.ProjectListDto;

public interface PortfolioDao {

	
	String NAMESPACE = "Portfolio.";

	public List<PortfolioListDto> selectList(Map<String,Object> portfolioPageMap);
	public PortfolioDetailDto selectOne(int bd_no);
	public int portfolioInsert(PortfolioInsertDto portfolioDto);
	public int delete(int bd_no);
	public int getPortfolioListCnt();
	public int update(PortfolioUpdateDto portfolioUpdateDto);
}
