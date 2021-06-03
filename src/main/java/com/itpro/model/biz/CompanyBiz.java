package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.company.CompanyResumeDto;

public interface CompanyBiz {

	int insert(Map<String, Integer> map);

	List<CompanyResumeDto> selectCompanyResumeList(int m_no);

	int updateStatusChange(Map<String, Object> map);
	

}
