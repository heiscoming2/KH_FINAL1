package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.board.BoardCategoryDto;

public interface BoardCategoryBiz {

	public List<BoardCategoryDto> selectList();
}
