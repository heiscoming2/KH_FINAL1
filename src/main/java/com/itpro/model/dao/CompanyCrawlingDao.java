package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.CompanyCrawlingDto;

public interface CompanyCrawlingDao {
	
	String NAMESPACE = "CompanyCrawling.";
	public List<CompanyCrawlingDto> selectList();
	public int insertlist(List<CompanyCrawlingDto> companyCrawlingList);
	public int deletelist();
	
}
