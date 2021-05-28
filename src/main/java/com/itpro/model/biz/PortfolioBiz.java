package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.portfolio.PortfolioDetailDto;
import com.itpro.model.dto.portfolio.PortfolioInsertDto;
import com.itpro.model.dto.portfolio.PortfolioListDto;
import com.itpro.model.dto.portfolio.PortfolioUpdateDto;

public interface PortfolioBiz {

	public List<PortfolioListDto> selectList(Map<String,Object> portfolioPageMap);
	public PortfolioDetailDto selectOne(int bd_no);
	public int portfolioInsert(PortfolioInsertDto portfolioDto);
	public int delete(int bd_no);
	public int update(PortfolioUpdateDto portfolioUpdateDto, BoardUpdateDto boardUpdateDto);
	public int getPortfolioListCnt();

}
