package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.CompanyCrawlingDto;

public interface CompanyCrawlingBiz {
	
	public int insertlist(List<CompanyCrawlingDto> companyCrawlingList);
	public int deletelist();
	public List<CompanyCrawlingDto> selectList();

}
