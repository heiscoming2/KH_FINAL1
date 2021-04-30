package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.StudyDto;
import com.itpro.model.dto.StudyListDto;

public interface StudyBiz {
	
	public List<StudyListDto> selectList();
	public StudyDto selectOne(int bd_no);
	public int insert(StudyDto studyDto);
	public int delete();
	public int update();

}
