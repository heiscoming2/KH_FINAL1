package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.BoardCategoryBiz;
import com.itpro.model.dao.BoardCategoryDao;
import com.itpro.model.dto.board.BoardCategoryDto;

@Service
public class BoardCategoryBizImpl implements BoardCategoryBiz{

	@Autowired
	BoardCategoryDao dao;
	
	@Override
	public List<BoardCategoryDto> selectList() {
		return dao.selectList();
	}

}
