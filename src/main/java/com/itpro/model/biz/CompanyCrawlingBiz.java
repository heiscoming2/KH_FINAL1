package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.CompanyCrawlingDto;
import com.itpro.model.dto.CompanyCrawlingSearchDto;

public interface CompanyCrawlingBiz {
	
	public int updatelist(List<CompanyCrawlingDto> companyCrawlingList);
	public int deletelist();
	public List<CompanyCrawlingDto> selectList(Map<String,Object> companyCrawlingPageMap);
	public List<CompanyCrawlingDto> selectschList(Map<String,Object> companyCrawlingPageMap);
	public int getCompanyCrawlingContentCnt();
	public int getCompanyCrawlingSearchCnt(CompanyCrawlingSearchDto companyCrawlingSearchDto);
}
