package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.study.StudyDetailDto;
import com.itpro.model.dto.study.StudyInsertDto;
import com.itpro.model.dto.study.StudyListDto;
import com.itpro.model.dto.study.StudySearchDto;
import com.itpro.model.dto.study.StudyUpdateDto;

public interface StudyDao {
	
	String NAMESPACE = "Study.";
	
	public List<StudyListDto> selectList(Map<String,Object> studyPageMap);
	public StudyDetailDto selectOne(int bd_no);
	public int studyInsert(StudyInsertDto studyDto);
	public int delete(int bd_no);
	public int update(StudyUpdateDto studyUpdateDto);
	public int getStudyListCnt();
	public int getStudySearchListCnt(StudySearchDto studySearchDto);
	public List<StudyListDto> selectSearchList(Map<String, Object> studySearchMap);


}
