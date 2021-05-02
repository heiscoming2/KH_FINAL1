package com.itpro.model.dao;

import com.itpro.model.dto.MemberDto;

public interface MemberDao {
	String NAMESPACE="itmember.";
	
	public MemberDto login(MemberDto dto);
}
