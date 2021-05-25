package com.itpro.model.daoImpl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.MemberDao;
import com.itpro.model.dao.ResumeDao;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;

@Repository
public class ResumeDaoImpl implements ResumeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	//이력서 등록
	@Override
	public MemberDto selectOne(int m_no) {
		
		return null;
	}

	

}
