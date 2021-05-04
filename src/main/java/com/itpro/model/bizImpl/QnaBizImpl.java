package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.QnaBiz;
import com.itpro.model.dao.QnaDao;
import com.itpro.model.dto.qna.QnaDto;

@Service
public class QnaBizImpl implements QnaBiz{

	@Autowired
	private QnaDao QnaDaoImpl;

	@Override
	public List<QnaDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QnaDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(QnaDto qnaDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	


}
