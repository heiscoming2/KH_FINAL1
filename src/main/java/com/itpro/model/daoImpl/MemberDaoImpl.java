package com.itpro.model.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.member.LoginDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public LoginDto login(LoginDto loginDto) {
		LoginDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"login", loginDto);
		} catch (Exception e) {
			
		}		
		
		return res;
	}

}
