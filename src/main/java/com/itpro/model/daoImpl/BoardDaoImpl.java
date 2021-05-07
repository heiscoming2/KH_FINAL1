package com.itpro.model.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.BoardDao;
import com.itpro.model.dto.board.BoardUpdateDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int update(BoardUpdateDto boardUpdateDto) {
		int BoardUpdateRes = sqlSession.update(NAMESPACE+"update",boardUpdateDto);
		return BoardUpdateRes;
	}
	

}
