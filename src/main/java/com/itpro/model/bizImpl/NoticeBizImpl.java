package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.NoticeBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dao.NoticeDao;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.notice.NoticeDto;
import com.itpro.model.dto.notice.NoticeSearchDto;

@Service
public class NoticeBizImpl implements NoticeBiz {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private LikeDao likeDao;
	
	@Override
	public List<NoticeDto> selectList(Map<String,Object> noticePageMap) {
		return noticeDao.selectList(noticePageMap);
	}

	@Override
	public NoticeDto selectOne(int bd_no) {
		return noticeDao.selectOne(bd_no);
	}

	@Override
	public int noticeInsert(NoticeDto noticeDto) {
		return noticeDao.noticeInsert(noticeDto);
	}

	@Override
	@Transactional
	public int delete(int bd_no) {
		int Deleteres = 0;
		int replyDeleteRes = replyDao.deleteWithBoard(bd_no);
		int likedeleteres = likeDao.deleteWithBoard(bd_no);
		int noticeDeleteRes = noticeDao.delete(bd_no);
		int boardDeleteRes = boardDao.delete(bd_no);
		if(noticeDeleteRes>0 && boardDeleteRes>0 && replyDeleteRes>0 && likedeleteres>0) {
			Deleteres = 1;
		}
		return Deleteres; 
	}

	@Override
	@Transactional
	public int update(NoticeDto noticeDto,BoardUpdateDto boardUpdateDto) {
		int res = 0;
		int noticeUpdateRes = noticeDao.update(noticeDto);
		int boardUpdateRes = boardDao.update(boardUpdateDto);
				if(noticeUpdateRes>0 && boardUpdateRes>0) {
			res = 1;
		}
		return res; 
	}
	
	
	

	@Override
	public int getNoticeListCnt(Map<String, Object> noticePageMap) {
		return noticeDao.getNoticeListCnt(noticePageMap);
	}

	@Override
	public int getNoticeListSearchCnt(NoticeSearchDto noticeSearchDto) {
		return noticeDao.getNoticeSearchListCnt(noticeSearchDto);
	}

	@Override
	public List<NoticeDto> selectSearchList(Map<String, Object> noticeSearchMap) {
		return noticeDao.selectSearchList(noticeSearchMap);
	}

	@Override
	public int getNoticeListCnt() {
		return noticeDao.getNoticeListCnt();
	}

}
	