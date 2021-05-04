package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.qna.QnaDto;

public interface QnaDao {

	
	String NAMESPACE = "Qna.";

	public List<QnaDto> selectList();
	public int insertlist(List<QnaDto> QnaList);
	public int deletelist();
}
