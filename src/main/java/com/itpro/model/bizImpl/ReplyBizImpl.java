package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.reply.ReplyInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.reply.ReplyUpdateDto;

@Service
public class ReplyBizImpl implements ReplyBiz {
	
	@Autowired
	public ReplyDao replyDao;
	
	@Override
	public List<ReplyListDto> selectList(int bd_no) {
		return replyDao.selectList(bd_no);
	}

	@Override
	public int replyCnt(int bd_no) {
		return replyDao.replyCnt(bd_no);
	}

	@Override
	public int insert(ReplyInsertDto replyInsertDto) {
		return replyDao.insert(replyInsertDto);
	}

	@Override
	public int update(ReplyUpdateDto replyUpdateDto) {
		return replyDao.update(replyUpdateDto);
	}

	@Override
	public int delete(int re_no) {
		return replyDao.delete(re_no);
	}

}
