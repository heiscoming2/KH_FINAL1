package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.CompanyCrawlingDto;
import com.itpro.model.dto.CompanyCrawlingSearchDto;

public interface CompanyCrawlingDao {
	
	String NAMESPACE = "CompanyCrawling.";
	public List<CompanyCrawlingDto> selectList(Map<String,Object> companyCrawlingPageMap);
	public List<CompanyCrawlingDto> selectschList(Map<String,Object> companyCrawlingPageMap);
	public int updatelist(List<CompanyCrawlingDto> companyCrawlingList);
	public int deletelist();
	public int getCompanyCrawlingContentCnt();
	public int getCompanyCrawlingSearchCnt(CompanyCrawlingSearchDto companyCrawlingSearchDto);
	
}
