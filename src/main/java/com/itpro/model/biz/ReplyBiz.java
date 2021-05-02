package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.ReplyDto;

public interface ReplyBiz {
	
	public List<ReplyDto> selectList();
}
