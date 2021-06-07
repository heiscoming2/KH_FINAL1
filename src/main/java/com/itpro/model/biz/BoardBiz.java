package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.board.BoardDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.board.SearchListDto;
import com.itpro.model.dto.mainpage.MainPageBoardDto;
import com.itpro.model.dto.mainpage.MainPagePortfolioDto;

public interface BoardBiz {
	
	public int update(BoardUpdateDto boardUpdateDto);
	public void updateviewcount(int bd_no);
	public BoardDto selectOne(int bd_no);
	public int selectListCnt(Map<String, Object> searchlistMap);
	public List<SearchListDto> selectSearchList(Map<String, Object> searchlistMap);
	public List<MainPageBoardDto> selectMainPageBoardList();
	public List<MainPagePortfolioDto> selectMainPortfolioList();
	public int muldel(List<Map<String, Integer>> muldelarr);
	
}
