package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.notice.NoticeDto;
import com.itpro.model.dto.notice.NoticeSearchDto;

public interface NoticeBiz {
	
	public List<NoticeDto> selectList(Map<String,Object> noticePageMap);
	public NoticeDto selectOne(int bd_no);
	public int noticeInsert(NoticeDto noticeDto);
	public int delete(int bd_no);
	public int update(NoticeDto noticeDto,BoardUpdateDto boardUpdateDto);
	public int getNoticeListCnt(Map<String, Object> noticePageMap);
	public int getNoticeListSearchCnt(NoticeSearchDto noticeSearchDto);
	public List<NoticeDto> selectSearchList(Map<String, Object> noticeSearchMap);
	public int getNoticeListCnt();
	
}
	