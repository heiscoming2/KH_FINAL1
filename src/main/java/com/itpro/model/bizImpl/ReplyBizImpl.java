package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.ReplyDto;

@Service
public class ReplyBizImpl implements ReplyBiz {
	
	@Autowired
	public ReplyDao replyDao;
	
	@Override
	public List<ReplyDto> selectList() {
		return null;
	}

}
