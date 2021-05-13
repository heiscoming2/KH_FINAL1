package com.itpro.model.bizImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.member.LoginDto;
import com.itpro.model.dto.member.RegBizDto;
import com.itpro.model.dto.member.RegDto;

@Service
public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberDao dao;
	
	//로그인
	@Override
	public LoginDto login(LoginDto loginDto) {
		
		return dao.login(loginDto);
	}

	//로그아웃
	@Override
	public void logout(HttpSession session) {
		dao.logout(session);
	}

	//개인회원가입
	@Override
	public int RegMember(RegDto regDto) {
		
		return dao.RegMember(regDto);
	}

	//기업회원가입
	@Override
	public int RegBizMember(RegBizDto regBizDto) {
		
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
	

	//회원정보 조회
	@Override
	public LoginDto select(int m_no) {
		return dao.select(m_no);
	}


	//개인회원정보수정(업데이트)
	@Override
	public int update(LoginDto loginDto) {
		
		return dao.update(loginDto);
	}
}
