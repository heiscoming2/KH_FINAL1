package com.itpro.model.dao;

import com.itpro.model.dto.member.LoginDto;

public interface MemberDao {
	String NAMESPACE="ItMember.";

	//로그인
	public LoginDto login(LoginDto loginDto);
}
