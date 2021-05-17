package com.itpro.model.dao;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;

public interface MemberDao {
	String NAMESPACE = "ItMember.";

	// 로그인
	public MemberDto login(MemberDto loginDto);

	// 개인회원 회원가입
	public int RegMember(MemberDto regDto);

	// 기업회원 회원가입
	public int RegBizMember(MemberDto regBizDto);

	// 중복 아이디체크
	public int idCheck(String m_id);

	// 중복 이메일 체크
	public int emailCheck(String m_email);

	// 중복 사업자번호 체크
	public int regnoCheck(String m_regno);

	//회원탈퇴(삭제)
	public String deleteMember(String m_id);	
	
	//탈퇴 아이디 체크
	public boolean checkPw(String m_id, String m_pw);

}
