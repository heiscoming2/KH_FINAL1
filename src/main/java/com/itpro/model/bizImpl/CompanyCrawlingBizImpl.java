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
	private CompanyCrawlingDao companyCrawlingDaoImpl;
	
	@Override
	@Transactional
	public int updatelist(List<CompanyCrawlingDto> companyCrawlingList) {
		deletelist();
		return companyCrawlingDaoImpl.updatelist(companyCrawlingList);
	}

	@Override
	public int deletelist() {
		return companyCrawlingDaoImpl.deletelist();
	}

	@Override
	public List<CompanyCrawlingDto> selectList(Map<String,Object> companyCrawlingPageMap) {
		List<CompanyCrawlingDto> companyCrawlingList = companyCrawlingDaoImpl.selectList(companyCrawlingPageMap);
		return companyCrawlingList;
	}

	@Override
	public int getCompanyCrawlingContentCnt() {
		return companyCrawlingDaoImpl.getCompanyCrawlingContentCnt();
	}

	@Override
	public int getCompanyCrawlingSearchCnt(CompanyCrawlingSearchDto companyCrawlingSearchDto) {
		System.out.println(companyCrawlingSearchDto.getSrc_a1());
		System.out.println(companyCrawlingSearchDto.getSrc_a2());
		System.out.println(companyCrawlingSearchDto.getSrc_cer());
		System.out.println(companyCrawlingSearchDto.getSrc_edu());
		System.out.println(companyCrawlingSearchDto.getSrc_key());
		return companyCrawlingDaoImpl.getCompanyCrawlingSearchCnt(companyCrawlingSearchDto);
	}

	@Override
	public List<CompanyCrawlingDto> selectschList(Map<String, Object> companyCrawlingPageMap) {
		
		return companyCrawlingDaoImpl.selectschList(companyCrawlingPageMap);
	}
}
