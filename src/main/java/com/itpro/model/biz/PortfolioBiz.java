package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.PortfolioDto;

public interface PortfolioBiz {

	public List<PortfolioDto> selectList();
	public PortfolioDto selectOne(int bd_no);
	public int insert(PortfolioDto portfolioDto);
	public int delete();
	public int update();

}
