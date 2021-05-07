package com.itpro.model.dao;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.LoginDto;
import com.itpro.model.dto.member.RegDto;

public interface MemberDao {
	String NAMESPACE="ItMember.";

	//로그인
	public LoginDto login(LoginDto loginDto);
	
	//로그아웃
	public void logout(HttpSession session);
	
	//회원가입
	public int RegMember(RegDto regDto);
}
