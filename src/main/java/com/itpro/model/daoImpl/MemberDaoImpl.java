package com.itpro.model.daoImpl;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.member.LoginDto;
import com.itpro.model.dto.member.RegDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//로그인
	@Override
	public LoginDto login(LoginDto loginDto) {
		LoginDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"login", loginDto);
		} catch (Exception e) {
			
		}		
		
		return res;
	}

	//로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	//회원가입
	@Override
	public int RegMember(RegDto regDto) {
		int res=0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"RegMember", regDto);
			
		} catch (Exception e) {
			System.out.println("[error] : RegMember");
			e.printStackTrace();
		}		
		
		return res;
	}
	
	//중복 아이디 체크
	@Override
	public int idCheck(String m_id) {
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"idCheck", m_id);
		} catch (Exception e) {
			
		}		
		
		return res;
	}
		

}
