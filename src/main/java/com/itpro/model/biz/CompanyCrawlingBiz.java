package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.crawling.CompanyCrawlingDto;
import com.itpro.model.dto.crawling.CompanyCrawlingSearchDto;

public interface CompanyCrawlingBiz {
	
	public int updatelist(List<CompanyCrawlingDto> companyCrawlingList);
	public int deletelist();
	public List<CompanyCrawlingDto> selectList(Map<String,Object> companyCrawlingPageMap);
	public List<CompanyCrawlingDto> selectschList(Map<String,Object> companyCrawlingPageMap);
	public int getCompanyCrawlingListCnt();
	public int getCompanyCrawlingSearchCnt(CompanyCrawlingSearchDto companyCrawlingSearchDto);
}
