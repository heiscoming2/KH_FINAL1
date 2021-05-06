package com.itpro.model.dao;

import com.itpro.model.dto.board.BoardUpdateDto;

public interface BoardDao {
	
	String NAMESPACE = "BOARD.";
	public int update(BoardUpdateDto boardUpdateDto);
	
}
