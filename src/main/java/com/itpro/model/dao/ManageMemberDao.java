package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.QnaDto;
import com.itpro.model.dto.admin.ManageMemberDto;

public interface ManageMemberDao {

	
	String NAMESPACE = "ManageMember.";

	public List<ManageMemberDto> selectList();
	public ManageMemberDto selectOne(int m_no);
	public int update(ManageMemberDto dto);
	
}
