package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.qna.QnaDto;

public interface ManageMemberDao {

	
	String NAMESPACE = "ManageMember.";

	public List<ManageMemberDto> selectList();
	public ManageMemberDto selectOne(int m_no);
	public int update(ManageMemberDto dto);
	
}
