package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.study.StudyDetailDto;
import com.itpro.model.dto.study.StudyInsertDto;
import com.itpro.model.dto.study.StudyJoinInfoDto;
import com.itpro.model.dto.study.StudyListDto;
import com.itpro.model.dto.study.StudySearchDto;
import com.itpro.model.dto.study.StudyUpdateDto;

public interface StudyBiz {
	
	public List<StudyListDto> selectList(Map<String,Object> studyPageMap);
	public StudyDetailDto selectOne(int bd_no);
	public int studyInsert(StudyInsertDto studyDto);
	public int delete(int bd_no);
	public int update(StudyUpdateDto studyUpdateDto,BoardUpdateDto boardUpdateDto);
	public int getStudyListCnt();
	public int getStudyListSearchCnt(StudySearchDto studySearchDto);
	public List<StudyListDto> selectSearchList(Map<String, Object> studySearchMap);
	public int updatestatus(int bd_no);
	public int studyJoinApplyInsert(StudyJoinInfoDto studyJoinInfoDto);
	public int studyJoinApplySelectOne(StudyJoinInfoDto studyJoinInfoDto);
	public List<StudyJoinInfoDto> studyJoinInfoSelectList(int bd_no);
	public List<StudyJoinInfoDto> studyJoinInfoSelectList(StudyJoinInfoDto studyJoinInfodto);
	public int studyJoinDelete(StudyJoinInfoDto studyJoinInfoDto);
	public int studyJoinAccept(StudyJoinInfoDto studyJoinInfoDto);
	
}
