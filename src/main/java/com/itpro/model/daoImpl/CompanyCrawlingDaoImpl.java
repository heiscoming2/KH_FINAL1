package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.dao.CompanyCrawlingDao;
import com.itpro.model.dto.CompanyCrawlingDto;

@Repository
public class CompanyCrawlingDaoImpl implements CompanyCrawlingDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CompanyCrawlingDto> selectList() {
		List<CompanyCrawlingDto> companyCrawlingList = sqlSession.selectList(NAMESPACE+"selectList");
		return companyCrawlingList;
	}

	@Override
	public int insertlist(List<CompanyCrawlingDto> companyCrawlingList) {
		int res = sqlSession.insert(NAMESPACE+"insertlist",companyCrawlingList);
		return res;
	}

	@Override
	public int deletelist() {
		int res = sqlSession.delete(NAMESPACE+"deletelist");
		return res;
	}

}
