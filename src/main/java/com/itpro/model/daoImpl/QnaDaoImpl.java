package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.QnaDao;
import com.itpro.model.dto.qna.QnaDetailDto;
import com.itpro.model.dto.qna.QnaInsertDto;
import com.itpro.model.dto.qna.QnaListDto;
import com.itpro.model.dto.qna.QnaSearchDto;
import com.itpro.model.dto.qna.QnaUpdateDto;

@Repository
public class QnaDaoImpl implements QnaDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	private Logger logger = LoggerFactory.getLogger(QnaDaoImpl.class);
	

	@Override
	public List<QnaListDto> selectList(Map<String, Object> qnaPageMap) {
		List<QnaListDto> qnaList = null;
		
		try {
			qnaList = sqlSession.selectList(NAMESPACE+"selectList", qnaPageMap);
			
			System.out.println("qnalist size: " + qnaList.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error]: select list");
		}
		System.out.println(qnaList.toString());
		return qnaList;
		
	}

	@Override
	public QnaDetailDto selectOne(int bd_no) {
		QnaDetailDto qnaDetailDto = null;
		try {
			qnaDetailDto = sqlSession.selectOne(NAMESPACE+"selectone", bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qnaDetailDto;
	}

	@Override
	public int qnaInsert(QnaInsertDto qnaDto) {
		int res = 0;
		try {
		 res = sqlSession.insert(NAMESPACE+"insert", qnaDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int bd_no) {
		int qnaDeleteRes = 0;
		try {
			qnaDeleteRes = sqlSession.delete(NAMESPACE+"delete",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qnaDeleteRes;
	}

	@Override
	public int update(QnaUpdateDto qnaUpdateDto) {
		int qnaUpdateRes = 0;
		try {
			qnaUpdateRes = sqlSession.update(NAMESPACE+"update", qnaUpdateDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return qnaUpdateRes;
	}

	@Override
	public int getQnaListCnt() {
		int qnaListCnt = 0;
		try {
			qnaListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"selectlistcnt").toString().replace("[","").replace("]", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qnaListCnt;
	}

	@Override
	public int getQnaSearchListCnt(QnaSearchDto qnaSearchDto) {
		int qnaSearchListCnt = 0;
		try {
			qnaSearchListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"qnasearchlistcnt",qnaSearchDto).toString().replace("[","").replace("]", ""));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return qnaSearchListCnt;
	}

	@Override
	public List<QnaListDto> selectSearchList(Map<String, Object> qnaSearchMap) {
		List<QnaListDto> qnaList = null;
		try {
			qnaList = sqlSession.selectList(NAMESPACE+"selectsearchlist",qnaSearchMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qnaList;
	}

	




}
