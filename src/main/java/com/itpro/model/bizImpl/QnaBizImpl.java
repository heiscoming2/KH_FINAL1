package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.QnaBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dao.QnaDao;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.qna.QnaDetailDto;
import com.itpro.model.dto.qna.QnaInsertDto;
import com.itpro.model.dto.qna.QnaListDto;
import com.itpro.model.dto.qna.QnaSearchDto;
import com.itpro.model.dto.qna.QnaUpdateDto;

@Service
public class QnaBizImpl implements QnaBiz {

	@Autowired
	private QnaDao qnaDao;

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private ReplyDao replyDao;

	@Autowired
	private LikeDao likeDao;

	@Override
	public List<QnaListDto> selectList(Map<String, Object> qnaPageMap) {
		return qnaDao.selectList(qnaPageMap);
	}

	@Override
	public QnaDetailDto selectOne(int bd_no) {
		return qnaDao.selectOne(bd_no);
	}

	@Override
	public int qnaInsert(QnaInsertDto qnaDto) {
		return qnaDao.qnaInsert(qnaDto);
	}

	@Override
	@Transactional
	public int delete(int bd_no) {
		int deleteres = 0;
		int replydeleteres = replyDao.deleteWithBoard(bd_no);
		int likedeleteres = likeDao.deleteWithBoard(bd_no);
		int qnadeleteres = qnaDao.delete(bd_no);
		int boarddeleteres = boardDao.delete(bd_no);
		if (qnadeleteres > 0 && boarddeleteres > 0 && replydeleteres > 0 && likedeleteres > 0) {
			deleteres = 1;
		}
		return deleteres;
	}

	@Override
	@Transactional
	public int update(QnaUpdateDto qnaUpdateDto, BoardUpdateDto boardUpdateDto) {
		int res = 0;
		int qnaUpdateRes = qnaDao.update(qnaUpdateDto);
		int boardUpdateRes = boardDao.update(boardUpdateDto);
		if (qnaUpdateRes > 0 && boardUpdateRes > 0) {
			res = 1;
		}
		return res;
	}

	@Override
	public int getQnaListCnt() {
		return qnaDao.getQnaListCnt();
	}

	/*
	 * @Override public int getQnaListSearchCnt(QnaSearchDto qnaSearchDto) { return
	 * qnaDao.getQnaSearchListCnt(qnaSearchDto); }
	 * 
	 * @Override public List<QnaListDto> selectSearchList(Map<String, Object>
	 * qnaSearchMap) { return qnaDao.selectSearchList(qnaSearchMap); }
	 */

}
