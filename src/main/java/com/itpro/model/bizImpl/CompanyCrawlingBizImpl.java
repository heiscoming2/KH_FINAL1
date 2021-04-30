package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.CompanyCrawlingBiz;
import com.itpro.model.dao.CompanyCrawlingDao;
import com.itpro.model.daoImpl.CompanyCrawlingDaoImpl;
import com.itpro.model.dto.CompanyCrawlingDto;
import com.itpro.model.dto.CompanyCrawlingSearchDto;

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
	public int getCompanyCrawlingContentCnt() {
		return companyCrawlingDao.getCompanyCrawlingContentCnt();
	}

	@Override
	public int getCompanyCrawlingSearchCnt(CompanyCrawlingSearchDto companyCrawlingSearchDto) {
		System.out.println(companyCrawlingSearchDto.getSrc_a1());
		System.out.println(companyCrawlingSearchDto.getSrc_a2());
		System.out.println(companyCrawlingSearchDto.getSrc_cer());
		System.out.println(companyCrawlingSearchDto.getSrc_edu());
		System.out.println(companyCrawlingSearchDto.getSrc_key());
		return companyCrawlingDao.getCompanyCrawlingSearchCnt(companyCrawlingSearchDto);
	}

	@Override
	public List<CompanyCrawlingDto> selectschList(Map<String, Object> companyCrawlingPageMap) {
		
		return companyCrawlingDao.selectschList(companyCrawlingPageMap);
	}
}
