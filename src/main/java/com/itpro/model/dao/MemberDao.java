package com.itpro.model.dao;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;

public interface MemberDao {
	String NAMESPACE="ItMember.";

	//로그인
	public MemberDto login(MemberDto loginDto);
	
	//로그아웃
	public void logout(HttpSession session);
	
	//개인회원 회원가입
	public int RegMember(MemberDto regDto);
	
	//기업회원 회원가입
	public int RegBizMember(MemberDto regBizDto);
	
	//중복 아이디체크
	public int idCheck(String m_id);
	
	//중복 이메일 체크
	public int emailCheck(String m_email);	

	//중복 사업자번호 체크
	public int regnoCheck(String m_regno);
	
	//회원정보 조회
	public MemberDto select(int m_no);
	
	//개인회원정보수정(업데이트)
	public int update(MemberDto loginDto);

	
}
