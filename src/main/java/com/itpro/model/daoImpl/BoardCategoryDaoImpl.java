package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.BoardCategoryDao;
import com.itpro.model.dto.board.BoardCategoryDto;

@Repository
public class BoardCategoryDaoImpl implements BoardCategoryDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public List<BoardCategoryDto> selectList(){
			
		return sqlSession.selectList(NAMESPACE+"selectlist");
	}
}
