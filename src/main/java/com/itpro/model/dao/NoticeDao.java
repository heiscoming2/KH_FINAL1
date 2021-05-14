package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.notice.NoticeDto;
import com.itpro.model.dto.notice.NoticeSearchDto;
import com.itpro.model.dto.study.StudyDetailDto;
import com.itpro.model.dto.study.StudyInsertDto;
import com.itpro.model.dto.study.StudyListDto;
import com.itpro.model.dto.study.StudySearchDto;
import com.itpro.model.dto.study.StudyUpdateDto;

public interface NoticeDao {
	
	String NAMESPACE = "Notice.";
	
	public List<NoticeDto> selectList(Map<String,Object> noticePageMap);
	public NoticeDto selectOne(int bd_no);
	public int noticeInsert(NoticeDto dto);
	public int delete(int bd_no);
	public int update(NoticeDto dto);
	public int getNoticeListCnt();
	public int getNoticeSearchListCnt(NoticeSearchDto noticeSearchDto);
	public List<NoticeDto> selectSearchList(Map<String, Object> noticeSearchMap);


}
