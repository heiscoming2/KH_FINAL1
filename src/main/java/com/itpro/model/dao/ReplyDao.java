package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.reply.ReplyInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.reply.ReplyUpdateDto;

public interface ReplyDao {
	
	String NAMESPACE = "reply.";
	
	public List<ReplyListDto> selectList(int bd_no);
	public int replyCnt(int bd_no);
	public int insert(ReplyInsertDto replyInsertDto);
	public int update(ReplyUpdateDto replyUpdateDto);
	public int delete(int re_no);
	public int updateOrder(int re_parentno);
	public int childrenCheck(int re_no);
	public int updateHidden(int re_no);
	
}
