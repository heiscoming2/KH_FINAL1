package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.QnaDao;
import com.itpro.model.dto.qna.QnaDto;

@Repository
public class QnaDaoImpl implements QnaDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<QnaDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertlist(List<QnaDto> QnaList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletelist() {
		// TODO Auto-generated method stub
		return 0;
	}




}
