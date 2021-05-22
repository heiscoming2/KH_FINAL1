package com.itpro.model.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.BoardDao;
import com.itpro.model.dto.board.BoardDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.notice.NoticeDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int update(BoardUpdateDto boardUpdateDto) {
		int BoardUpdateRes = 0; 
		try {
			BoardUpdateRes = sqlSession.update(NAMESPACE+"update",boardUpdateDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BoardUpdateRes;
	}

	@Override
	public void updateviewcount(int bd_no) {
		try {
			sqlSession.update(NAMESPACE+"updateviewcount",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int delete(int bd_no) {
		int BoardDeleteRes = 0;
		try {
			BoardDeleteRes = sqlSession.delete(NAMESPACE+"delete",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BoardDeleteRes;
	}
	
	@Override
	public BoardDto selectOne(int bd_no) {
		BoardDto dto = null;
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectone",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	

}
