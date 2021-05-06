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
			res = sqlSession.insert(NAMESPACE+"insert", regDto);
			
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}		
		
		return res;
	}
		

}
