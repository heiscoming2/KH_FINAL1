package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.StudyDto;
import com.itpro.model.dto.StudyListDto;

public interface StudyDao {
	
	String NAMESPACE = "Study.";
	
	public List<StudyListDto> selectList();
	public StudyDto selectOne(int bd_no);
	public int insert(StudyDto studyDto);
	public int delete();
	public int update();


}
