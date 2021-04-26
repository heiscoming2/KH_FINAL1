package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.CompanyCrawlingDto;

public interface CompanyCrawlingDao {
	
	public List<CompanyCrawlingDto> selectAll();
	public int insert(List<CompanyCrawlingDto> list);

}
