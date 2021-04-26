package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.CompanyCrawlingBiz;
import com.itpro.model.dao.CompanyCrawlingDao;
import com.itpro.model.dto.CompanyCrawlingDto;

@Service
public class CompanyCrawlingBizImpl implements CompanyCrawlingBiz {
	
	@Autowired
	private CompanyCrawlingDao companyCrawlingDao;
	
	@Override
	public int insert(List<CompanyCrawlingDto> companyCrawlingList) {
		return companyCrawlingDao.insert(companyCrawlingList);
	}

}
