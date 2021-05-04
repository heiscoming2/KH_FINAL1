package com.itpro.model.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.member.LoginDto;

@Service
public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberDao dao;
	
	@Override
	public LoginDto login(LoginDto loginDto) {
		
		return dao.login(loginDto);
	}

	
}
