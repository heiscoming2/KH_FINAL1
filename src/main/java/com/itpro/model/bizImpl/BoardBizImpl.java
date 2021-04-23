package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.dto.BoardDto;


@Service
public class BoardBizImpl implements BoardBiz{
	
	@Autowired

	@Override
	public List<BoardDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDto selectOne(int myno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int myno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
