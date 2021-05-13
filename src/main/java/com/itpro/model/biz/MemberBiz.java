package com.itpro.model.biz;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.LoginDto;
import com.itpro.model.dto.member.RegBizDto;
import com.itpro.model.dto.member.RegDto;

public interface MemberBiz {	
	//로그인
	public LoginDto login(LoginDto loginDto);
	
	//로그아웃
	public void logout(HttpSession session);
	
	//개인회원가입
	public int RegMember(RegDto regDto);
	
	//기업회원가입
	public int RegBizMember(RegBizDto regBizDto);
	
	//중복아이디 체크
	public int idCheck(String m_id);
	
	//중복 이메일 체크
	public int emailChk(String m_email);
	
	//중복사업자번호 체크
	public int regnoChk(String m_regno);
	
	//회원정보 조회
	public LoginDto select(int m_no);

	//회원정보 수정
	public int update(LoginDto loginDto);

	
	
	
	
	
}
