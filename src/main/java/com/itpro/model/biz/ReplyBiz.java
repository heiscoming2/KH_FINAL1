package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.reply.ReplyInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.reply.ReplyUpdateDto;

public interface ReplyBiz {
	
	public List<ReplyListDto> selectList(int bd_no);
	public int replyCnt(int bd_no);
	public int insert(ReplyInsertDto replyInsertDto);
	public int update(ReplyUpdateDto replyUpdateDto);
	public int delete(int re_no);
	
	
}
