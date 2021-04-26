package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.CompanyCrawlingBiz;
import com.itpro.model.dao.CompanyCrawlingDao;
import com.itpro.model.daoImpl.CompanyCrawlingDaoImpl;
import com.itpro.model.dto.CompanyCrawlingDto;

@Service
public class CompanyCrawlingBizImpl implements CompanyCrawlingBiz {
	
	@Autowired
	private CompanyCrawlingDao companyCrawlingDaoImpl;
	
	@Override
	@Transactional
	public int insertlist(List<CompanyCrawlingDto> companyCrawlingList) {
		deletelist();
		return companyCrawlingDaoImpl.insertlist(companyCrawlingList);
	}

	@Override
	public int deletelist() {
		return companyCrawlingDaoImpl.deletelist();
	}

	@Override
	public List<CompanyCrawlingDto> selectList() {
		List<CompanyCrawlingDto> companyCrawlingList = companyCrawlingDaoImpl.selectList();
		return companyCrawlingList;
	}
}
