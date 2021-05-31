package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.report.ReportDto;

public interface ReportBiz {

	public List<ReportDto> selectList();
	public ReportDto selectOne(int bd_no);
	public int insert(ReportDto dto);
	public int insertreportform(ReportDto dto);
	public int getReportCnt();
	public ReportDto select2(int bd_no);
	public int delete(int report_no);

}
