package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.report.ReportReplyDto;

public interface ReportReplyBiz {

	public List<ReportReplyDto> selectList();
	public List<ReportReplyDto> selectList2(int re_no);
	public int insert(ReportReplyDto dto);
	public int insertreportform(ReportReplyDto dto);
	public int getReportReplyCnt();
	public ReportReplyDto select2(int re_no);
	public int delete(int report_reply_no);

}
