package com.itpro.model.dao;

import com.itpro.model.dto.member.MemberDto;

public interface MemberDao {
	String NAMESPACE="itmember.";
	
	public MemberDto login(MemberDto dto);
}
