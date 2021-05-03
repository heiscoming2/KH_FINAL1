package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.QnaDto;
import com.itpro.model.dto.admin.ManageMemberDto;

public interface ManageMemberDao {

	
	String NAMESPACE = "ManageMember.";

	public List<ManageMemberDto> selectList();
	public int updatelist(List<ManageMemberDto> ManageMemberList);
	
}
