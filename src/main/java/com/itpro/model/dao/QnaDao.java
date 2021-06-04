package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.qna.QnaDetailDto;
import com.itpro.model.dto.qna.QnaInsertDto;
import com.itpro.model.dto.qna.QnaListDto;
import com.itpro.model.dto.qna.QnaSearchDto;
import com.itpro.model.dto.qna.QnaUpdateDto;

public interface QnaDao {

	
	String NAMESPACE = "Qna.";

	public List<QnaListDto> selectList(Map<String,Object> qnaPageMap);
	public QnaDetailDto selectOne(int bd_no);
	public int qnaInsert(QnaInsertDto qnaDto);
	public int delete(int bd_no);
	public int update(QnaUpdateDto qnaUpdateDto);
	public int getQnaListCnt();
	/*
	 * public int getQnaSearchListCnt(QnaSearchDto qnaSearchDto); public
	 * List<QnaListDto> selectSearchList(Map<String, Object> qnaSearchMap);
	 */
}
