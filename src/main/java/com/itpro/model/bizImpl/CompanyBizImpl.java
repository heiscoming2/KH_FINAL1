package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.CompanyBiz;
import com.itpro.model.dao.CompanyDao;
import com.itpro.model.dto.company.CompanyResumeDto;

@Service
public class CompanyBizImpl implements CompanyBiz {

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public int insert(Map<String, Integer> map) {
		return companyDao.insert(map);
	}

	@Override
	public List<CompanyResumeDto> selectCompanyResumeList(int m_no) {
		return companyDao.selectCompanyResumeList(m_no);
	}

	@Override
	public int updateStatusChange(Map<String, Object> map) {
		return companyDao.updateStatusChange(map);
	}

}
