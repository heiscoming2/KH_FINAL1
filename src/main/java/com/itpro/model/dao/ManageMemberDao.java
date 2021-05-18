package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.admin.ManageMemberDto_com;


public interface ManageMemberDao {

	
	String NAMESPACE = "ManageMember.";

	//개인회원 + 관리자
	public List<ManageMemberDto> selectList();
	public ManageMemberDto selectOne(int m_no);
	public int update(ManageMemberDto dto);
	
	//기업회원
	public List<ManageMemberDto_com> selectList_com();
	public ManageMemberDto_com selectOne_com(int m_no);
	public int update_com(ManageMemberDto_com dto);
	
}
