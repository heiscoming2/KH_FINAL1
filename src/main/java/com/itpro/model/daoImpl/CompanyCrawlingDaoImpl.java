package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.CompanyCrawlingDao;
import com.itpro.model.dto.CompanyCrawlingDto;

@Repository
public class CompanyCrawlingDaoImpl implements CompanyCrawlingDao {
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public List<CompanyCrawlingDto> selectAll() {
		return null;
	}

	@Override
	public int insert(List<CompanyCrawlingDto> list) {
		
		return 0;
	}

}
