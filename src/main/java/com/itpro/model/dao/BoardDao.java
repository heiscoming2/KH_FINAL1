package com.itpro.model.dao;

import com.itpro.model.dto.board.BoardDto;
import com.itpro.model.dto.board.BoardUpdateDto;

public interface BoardDao {
	
	String NAMESPACE = "BOARD.";
	public int update(BoardUpdateDto boardUpdateDto);
	public void updateviewcount(int bd_no);
	public int delete(int bd_no);
	public BoardDto selectOne(int bd_no);
	
}
