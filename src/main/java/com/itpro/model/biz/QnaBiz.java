package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.qna.QnaDto;

public interface QnaBiz {

	public List<QnaDto> selectList();
	public QnaDto selectOne(int bd_no);
	public int insert(QnaDto qnaDto);
	public int delete();
	public int update();

}
