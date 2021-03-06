package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.CompanyCrawlingBiz;
import com.itpro.model.dao.CompanyCrawlingDao;
import com.itpro.model.daoImpl.CompanyCrawlingDaoImpl;
import com.itpro.model.dto.crawling.CompanyCrawlingDto;
import com.itpro.model.dto.crawling.CompanyCrawlingSearchDto;

@Service
public class CompanyCrawlingBizImpl implements CompanyCrawlingBiz {
	
	@Autowired
	private CompanyCrawlingDao companyCrawlingDao;
	
	@Override
	@Transactional
	public int updatelist(List<CompanyCrawlingDto> companyCrawlingList) {
		deletelist();
		return companyCrawlingDao.updatelist(companyCrawlingList);
	}

	@Override
	public int deletelist() {
		return companyCrawlingDao.deletelist();
	}

	@Override
	public List<CompanyCrawlingDto> selectList(Map<String,Object> companyCrawlingPageMap) {
		List<CompanyCrawlingDto> companyCrawlingList = companyCrawlingDao.selectList(companyCrawlingPageMap);
		return companyCrawlingList;
	}

	@Override
	public int getCompanyCrawlingListCnt() {
		return companyCrawlingDao.getCompanyCrawlingListCnt();
	}

	@Override
	public int getCompanyCrawlingSearchCnt(CompanyCrawlingSearchDto companyCrawlingSearchDto) {
		return companyCrawlingDao.getCompanyCrawlingSearchCnt(companyCrawlingSearchDto);
	}

	@Override
	public List<CompanyCrawlingDto> selectschList(Map<String, Object> companyCrawlingPageMap) {
		
		return companyCrawlingDao.selectschList(companyCrawlingPageMap);
	}
}
