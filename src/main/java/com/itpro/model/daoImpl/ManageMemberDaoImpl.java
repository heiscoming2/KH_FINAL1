package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ManageMemberDao;
import com.itpro.model.dao.QnaDao;
import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.qna.QnaDto;

@Repository
public class ManageMemberDaoImpl implements ManageMemberDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ManageMemberDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int updatelist(List<ManageMemberDto> ManageMemberList) {
		// TODO Auto-generated method stub
		return 0;
	}




}
