package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.NoticeBiz;
import com.itpro.model.biz.PortfolioBiz;
import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.biz.QnaBiz;
import com.itpro.model.biz.StudyBiz;
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
	
	@Autowired
	private ProjectBiz projectBiz;
	
	@Autowired
	private QnaBiz qnaBiz;
	
	@Autowired
	private StudyBiz studyBiz;
	
	@Autowired
	private NoticeBiz noticeBiz;
	
	@Autowired
	private PortfolioBiz portfolioBiz;	
		
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

	@Override
	@Transactional
	public int muldel(List<Map<String, Integer>> muldelarr) {
		
		int sum = 0;
		for(Map<String,Integer> map:muldelarr) {
			switch(map.get("bc_code")) {
			case 1 : projectBiz.delete(map.get("bd_no"));
					 sum++;
					 continue;
			case 2 : qnaBiz.delete(map.get("bd_no"));
					 sum++;
					 continue;
			case 3 : studyBiz.delete(map.get("bd_no"));
					 sum++;
					 continue;
			case 5 : noticeBiz.delete(map.get("bd_no"));
					 sum++;
					 continue;
			case 7 : portfolioBiz.delete(map.get("bd_no"));
					 sum++;
					 continue;
			}
		}
		if(sum==muldelarr.size()) {
			return sum;
		} else {
			return 0;
		}
	}
}
