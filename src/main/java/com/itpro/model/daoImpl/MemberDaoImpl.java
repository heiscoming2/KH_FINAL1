package com.itpro.model.daoImpl;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.member.LoginDto;
import com.itpro.model.dto.member.RegBizDto;
import com.itpro.model.dto.member.RegDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 로그인
	@Override
	public LoginDto login(LoginDto loginDto) {
		LoginDto res = null;

		try {
			res = sqlSession.selectOne(NAMESPACE + "login", loginDto);
		} catch (Exception e) {

		}

		return res;
	}

	// 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	// 개인회원 회원가입
	@Override
	public int RegMember(RegDto regDto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "RegMember", regDto);

		} catch (Exception e) {
			System.out.println("[error] : RegMember");
			e.printStackTrace();
		}

		return res;
	}
	
	//기업회원 회원가입
	@Override
	public int RegBizMember(RegBizDto regBizDto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "RegBizMember", regBizDto);

		} catch (Exception e) {
			System.out.println("[error] : RegBizMember");
			e.printStackTrace();
		}

		return res;
	}

	// 중복 아이디 체크
	@Override
	public int idCheck(String m_id) {
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "idCheck", m_id);
		} catch (Exception e) {

		}

		return res;
	}

	// 중복 이메일 체크
	@Override
	public int emailCheck(String m_email) {
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "emailCheck", m_email);
		} catch (Exception e) {

		}

		return res;
	}

	//중복사업자번호 체크
	@Override
	public int regnoCheck(String m_regno) {
		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "regnoCheck", m_regno);
		} catch (Exception e) {

		}

		return res;
	}
	
	@Override
	public LoginDto select(int m_no) {
		LoginDto res = null;

		try {
			res = sqlSession.selectOne(NAMESPACE + "select", m_no);
		} catch (Exception e) {

		}

		return res;
	}
	
	//개인회원 정보수정(업데이트)
	@Override
	public int update(LoginDto loginDto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"update",loginDto);
		} catch (Exception e) {
			System.out.println("[error]:update");
			e.printStackTrace();
		}	
		
		return res;
	}
}
