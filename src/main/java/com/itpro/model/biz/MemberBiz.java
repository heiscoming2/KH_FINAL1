package com.itpro.model.biz;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;

public interface MemberBiz {
	// 로그인
	public MemberDto login(MemberDto loginDto);

	// 개인회원가입
	public int RegMember(MemberDto regDto);

	// 기업회원가입
	public int RegBizMember(MemberDto regBizDto);

	// 중복아이디 체크
	public int idCheck(String m_id);

	// 중복 이메일 체크
	public int emailChk(String m_email);

	// 중복사업자번호 체크
	public int regnoChk(String m_regno);

	// 회원탈퇴(삭제)
	public String deleteMember(String m_id);

	// 회원삭제 비밀번호 체크
	public boolean checkPw(String m_id, String m_pw);

}
