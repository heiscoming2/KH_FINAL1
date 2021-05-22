package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.board.BoardCategoryDto;

public interface BoardCategoryDao {

	String NAMESPACE = "BOARDCATEGORY.";
	public List<BoardCategoryDto> selectList();
}
