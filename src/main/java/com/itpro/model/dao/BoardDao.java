package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.board.BoardDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.board.SearchListDto;
import com.itpro.model.dto.mainpage.MainPageBoardDto;
import com.itpro.model.dto.mainpage.MainPagePortfolioDto;

public interface BoardDao {
	
	String NAMESPACE = "BOARD.";
	public int update(BoardUpdateDto boardUpdateDto);
	public void updateviewcount(int bd_no);
	public int delete(int bd_no);
	public BoardDto selectOne(int bd_no);
	public int selectListCnt(Map<String, Object> searchlistMap);
	public List<SearchListDto> selectSearchList(Map<String, Object> searchlistMap);
	public List<MainPageBoardDto> selectMainPageBoardList();
	public List<MainPagePortfolioDto> selectMainPortfolioList();
	
}
