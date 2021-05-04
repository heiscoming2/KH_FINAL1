package com.itpro.model.biz;

import com.itpro.model.dto.member.LoginDto;

public interface MemberBiz {	
	//로그인
	public LoginDto login(LoginDto loginDto);
	
}
