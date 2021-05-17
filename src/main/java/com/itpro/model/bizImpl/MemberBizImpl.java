package com.itpro.model.bizImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.member.MemberDto;

@Service
public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberDao dao;
	
	//로그인
	@Override
	public MemberDto login(MemberDto loginDto) {
		
		return dao.login(loginDto);
	}

	//개인회원가입
	@Override
	public int RegMember(MemberDto regDto) {
		
		return dao.RegMember(regDto);
	}

	//기업회원가입
	@Override
	public int RegBizMember(MemberDto regBizDto) {
		
		return dao.RegBizMember(regBizDto);
	}

	//아이디 중복확인
	@Override
	public int idCheck(String m_id) {
		
		return dao.idCheck(m_id);
	}
	
	//이메일 중복 확인
	@Override
	public int emailChk(String m_email) {
		
		return dao.emailCheck(m_email);
	}
	
	//사업자번호 중복확인
	@Override
	public int regnoChk(String m_regno) {
		
		return dao.regnoCheck(m_regno);
	}
	
	//회원 탈퇴(삭제)
	@Override
	public String deleteMember(String m_id) {
		
		return dao.deleteMember(m_id);
	}

	//탈퇴아이디 체크
	@Override
	public boolean checkPw(String m_id, String m_pw) {
		
		return dao.checkPw(m_id, m_pw);
	}
}
