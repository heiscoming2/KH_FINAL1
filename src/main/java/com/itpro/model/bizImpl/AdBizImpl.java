package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.AdBiz;
import com.itpro.model.dao.AdDao;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.ad.AdDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.qna.QnaDetailDto;
import com.itpro.model.dto.qna.QnaInsertDto;
import com.itpro.model.dto.qna.QnaUpdateDto;

@Service
public class AdBizImpl implements AdBiz {

	@Autowired
	private AdDao adDao;

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private ReplyDao replyDao;

	@Autowired
	private LikeDao likeDao;

	@Override
	public List<AdDto> selectList(Map<String, Object> adPageMap) {
		return adDao.selectList(adPageMap);
	}

	@Override
	public AdDto selectOne(int bd_no) {
		return adDao.selectOne(bd_no);
	}

	@Override
	public int insert(AdDto dto) {
		return adDao.insert(dto);
	}

	@Override
	@Transactional
	public int delete(int bd_no) {
		int deleteres = 0;
		int replydeleteres = replyDao.deleteWithBoard(bd_no);
		int likedeleteres = likeDao.deleteWithBoard(bd_no);
		int qnadeleteres = adDao.delete(bd_no);
		int boarddeleteres = boardDao.delete(bd_no);
		if (qnadeleteres > 0 && boarddeleteres > 0 && replydeleteres > 0 && likedeleteres > 0) {
			deleteres = 1;
		}
		return deleteres;
	}

	@Override
	@Transactional
	public int update(AdDto dto, BoardUpdateDto boardUpdateDto) {
		int res = 0;
		int qnaUpdateRes = adDao.update(dto);
		int boardUpdateRes = boardDao.update(boardUpdateDto);
		if (qnaUpdateRes > 0 && boardUpdateRes > 0) {
			res = 1;
		}
		return res;
	}

	@Override
	public int getAdListCnt() {
		return adDao.getAdListCnt();
	}

}