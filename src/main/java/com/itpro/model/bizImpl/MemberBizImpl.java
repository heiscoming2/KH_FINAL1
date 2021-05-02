package com.itpro.model.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.MemberDto;

public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberDao dao;
	
	@Override
	public MemberDto login(MemberDto dto) {
		
		return dao.login(dto);
	}
	
}
