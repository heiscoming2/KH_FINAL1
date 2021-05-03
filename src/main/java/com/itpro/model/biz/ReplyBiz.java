package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.reply.ReplyInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;

public interface ReplyBiz {
	
	public List<ReplyListDto> selectList(int bd_no);
	public int replyCnt(int bd_no);
	public int insert(ReplyInsertDto replyInsertDto);
	
}
