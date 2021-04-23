package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int myno);
	
	public String test();
	
	
	
}
