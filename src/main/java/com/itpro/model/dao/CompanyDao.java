package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.company.CompanyResumeDto;

public interface CompanyDao {
	
	public static final String NAMESPACE = "Company.";

	public int insert(Map<String, Integer> map);

	public List<CompanyResumeDto> selectCompanyResumeList(int m_no);

	public int updateStatusChange(Map<String, Object> map);


}
