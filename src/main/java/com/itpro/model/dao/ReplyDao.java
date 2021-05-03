package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.reply.ReplyInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;

public interface ReplyDao {
	
	String NAMESPACE = "reply.";
	
	public List<ReplyListDto> selectList(int bd_no);
	public int replyCnt(int bd_no);
	public int insert(ReplyInsertDto replyInsertDto);
	
}
