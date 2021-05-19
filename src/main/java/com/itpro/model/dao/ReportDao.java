package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.report.ReportDto;

public interface ReportDao {

	
	String NAMESPACE = "Report.";

	public List<ReportDto> selectList();
	public ReportDto selectOne(int report_no);
	public int insert(ReportDto dto);
	public int insertreportform(ReportDto dto);
	public int getReportCnt();
}
