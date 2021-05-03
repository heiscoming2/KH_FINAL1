package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.ReplyDto;

public interface ReplyDao {
	
	String NAMESPACE = "reply.";
	
	public List<ReplyDto> selectList(int bd_no);
	public int replyCnt(int bd_no);

}
