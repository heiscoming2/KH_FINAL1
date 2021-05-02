package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.StudyDetailDto;
import com.itpro.model.dto.StudyDto;
import com.itpro.model.dto.StudyListDto;

public interface StudyBiz {
	
	public List<StudyListDto> selectList(Map<String,Object> studyPageMap);
	public StudyDetailDto selectOne(int bd_no);
	public int studyInsert(StudyDto studyDto);
	public int delete();
	public int update();
	public int getStudyListCnt();

}
