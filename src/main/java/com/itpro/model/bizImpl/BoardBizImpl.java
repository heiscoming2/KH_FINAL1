package com.itpro.model.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dto.board.BoardUpdateDto;

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
}
