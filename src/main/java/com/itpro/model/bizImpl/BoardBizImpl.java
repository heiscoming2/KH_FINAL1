package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dto.board.BoardDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.board.SearchListDto;
import com.itpro.model.dto.mainpage.MainPageBoardDto;
import com.itpro.model.dto.mainpage.MainPagePortfolioDto;

@Service
public class BoardBizImpl implements BoardBiz {

	@Autowired
	private BoardDao boardDao;
	
	public int update(BoardUpdateDto boardUpdateDto) {
		return boardDao.update(boardUpdateDto);
	}

	@Override
	public void updateviewcount(int bd_no) {
		boardDao.updateviewcount(bd_no);
	}
	
	public BoardDto selectOne(int bd_no) {
		return boardDao.selectOne(bd_no);
				
	}

	@Override
	public int selectListCnt(Map<String, Object> searchlistMap) {
		return boardDao.selectListCnt(searchlistMap);
	}

	@Override
	public List<SearchListDto> selectSearchList(Map<String, Object> searchlistMap) {
		return boardDao.selectSearchList(searchlistMap);
	}

	@Override
	public List<MainPageBoardDto> selectMainPageBoardList() {
		return boardDao.selectMainPageBoardList();
	}

	@Override
	public List<MainPagePortfolioDto> selectMainPortfolioList() {
		return boardDao.selectMainPortfolioList();
	}
}
