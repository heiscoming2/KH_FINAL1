package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.BoardDao;
import com.itpro.model.dto.board.BoardDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.board.SearchListDto;
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

	@Override
	public int selectListCnt(Map<String, Object> searchlistMap) {
		int res = 0;
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectlistcnt",searchlistMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<SearchListDto> selectSearchList(Map<String, Object> searchlistMap) {
		List<SearchListDto> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"selectsearchlist",searchlistMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
