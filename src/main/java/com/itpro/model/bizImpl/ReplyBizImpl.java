package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public int insert(ReplyInsertDto replyInsertDto) {
		
		//하나라도 실패시 rollback해야하므로 트랜잭션을 걸어준다.
		//부모 댓글인 경우 바로 insert만 실행하면됨
		//댓글에 댓글인 경우에 UPDATE 수행해야됨
		
		if(replyInsertDto.getRe_parentno()!=0) {
			int re_parentno = replyInsertDto.getRe_parentno();
				System.out.println("reply insert biz reparent no : "+re_parentno);
				replyDao.orderUpdate(re_parentno);
			}
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
