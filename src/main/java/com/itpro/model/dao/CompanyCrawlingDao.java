package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.crawling.CompanyCrawlingDto;
import com.itpro.model.dto.crawling.CompanyCrawlingSearchDto;

public interface CompanyCrawlingDao {
	
	String NAMESPACE = "CompanyCrawling.";
	public List<CompanyCrawlingDto> selectList(Map<String,Object> companyCrawlingPageMap);
	public List<CompanyCrawlingDto> selectschList(Map<String,Object> companyCrawlingPageMap);
	public int updatelist(List<CompanyCrawlingDto> companyCrawlingList);
	public int deletelist();
	public int getCompanyCrawlingListCnt();
	public int getCompanyCrawlingSearchCnt(CompanyCrawlingSearchDto companyCrawlingSearchDto);
	
}
