package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.report.ReportDto;

public interface ReportBiz {

	public List<ReportDto> selectList();
	public ReportDto selectOne(int m_no);
	public int insert(ReportDto dto);

}
