package com.itpro.model.biz;

import com.itpro.model.dto.board.BoardDto;
import com.itpro.model.dto.board.BoardUpdateDto;

public interface BoardBiz {
	
	public int update(BoardUpdateDto boardUpdateDto);
	public void updateviewcount(int bd_no);
	public BoardDto selectOne(int bd_no);
}
