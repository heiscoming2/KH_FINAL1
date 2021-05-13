package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.qna.QnaDto;

public interface ManageMemberDao {

	
	String NAMESPACE = "ManageMember.";

	//개인회원 + 관리자
	public List<ManageMemberDto> selectList();
	public ManageMemberDto selectOne(int m_no);
	public int update(ManageMemberDto dto);
	
	//기업회원
	public List<ManageMemberDto> selectList_com();
	public ManageMemberDto selectOne_com(int m_no);
	public int update_com(ManageMemberDto dto);
	
}
