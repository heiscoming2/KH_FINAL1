package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.report.ReportDto;
import com.itpro.model.dto.report.ReportReplyDto;

public interface ReportReplyDao {

	
	String NAMESPACE = "ReportReply.";

	public List<ReportReplyDto> selectList();
	public ReportReplyDto selectOne(int report_reply_no);
	public int insert(ReportReplyDto dto);
	public int insertreportform(ReportReplyDto dto);
	public int getReportReplyCnt();
	public ReportReplyDto select2(int re_no);
	public int delete(int report_reply_no);
}
