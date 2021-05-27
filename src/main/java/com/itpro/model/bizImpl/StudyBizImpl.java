package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.StudyBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dao.StudyDao;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.study.StudyDetailDto;
import com.itpro.model.dto.study.StudyInsertDto;
import com.itpro.model.dto.study.StudyJoinInfoDto;
import com.itpro.model.dto.study.StudyListDto;
import com.itpro.model.dto.study.StudySearchDto;
import com.itpro.model.dto.study.StudyUpdateDto;

@Service
public class StudyBizImpl implements StudyBiz {
	
	@Autowired
	private StudyDao studyDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private LikeDao likeDao;
	
	@Override
	public List<StudyListDto> selectList(Map<String,Object> studyPageMap) {
		return studyDao.selectList(studyPageMap);
	}

	@Override
	public StudyDetailDto selectOne(int bd_no) {
		return studyDao.selectOne(bd_no);
	}

	@Override
	public int studyInsert(StudyInsertDto studyDto) {
		return studyDao.studyInsert(studyDto);
	}

	@Override
	@Transactional
	public int delete(int bd_no) {
		int deleteres = 0;
		int replydeleteres = replyDao.deleteWithBoard(bd_no);
		int likedeleteres = likeDao.deleteWithBoard(bd_no);
		int studydeleteres = studyDao.delete(bd_no);
		int boarddeleteres = boardDao.delete(bd_no);
		if(studydeleteres>0 && boarddeleteres>0 && replydeleteres>0 && likedeleteres>0) {
			deleteres = 1;
		}
		return deleteres; 
	}

	@Override
	@Transactional
	public int update(StudyUpdateDto studyUpdateDto,BoardUpdateDto boardUpdateDto) {
		int res = 0;
		int studyUpdateRes = studyDao.update(studyUpdateDto);
		int boardUpdateRes = boardDao.update(boardUpdateDto);
		if(studyUpdateRes>0 && boardUpdateRes>0) {
			res = 1;
		}
		return res; 
	}

	@Override
	public int getStudyListCnt() {
		// TODO Auto-generated method stub
		return studyDao.getStudyListCnt();
	}

	@Override
	public int getStudyListSearchCnt(StudySearchDto studySearchDto) {
		return studyDao.getStudySearchListCnt(studySearchDto);
	}

	@Override
	public List<StudyListDto> selectSearchList(Map<String, Object> studySearchMap) {
		return studyDao.selectSearchList(studySearchMap);
	}

	@Override
	public int updatestatus(int bd_no) {
		return studyDao.updatestatus(bd_no);
	}

	@Override
	public int studyJoinApplyInsert(StudyJoinInfoDto studyJoinInfoDto) {
		int res = studyDao.studyJoinApplyInsert(studyJoinInfoDto);
		return 0;
	}

}
