package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.ReportReplyBiz;
import com.itpro.model.dao.ReportReplyDao;
import com.itpro.model.dto.report.ReportReplyDto;

@Service
public class ReportReplyBizImpl implements ReportReplyBiz{

	@Autowired
	private ReportReplyDao dao;

	
	@Override
	public List<ReportReplyDto> selectList() {
		return dao.selectList();
	}

	@Override
	public ReportReplyDto selectOne(int re_no) {
		return dao.selectOne(re_no);
	}

	@Override
	public int insert(ReportReplyDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int insertreportform(ReportReplyDto dto) {
		int res=0;
		
		int insertreportform = dao.insertreportform(dto);
		
		if(insertreportform>0) {
			res=1;
		}
		
		return res;
	}

	@Override
	public int getReportReplyCnt() {
		return dao.getReportReplyCnt();
	}

	@Override
	public ReportReplyDto select2(int re_no) {
		return dao.select2(re_no);
	}

	


}
