package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.ManageMemberBiz;
import com.itpro.model.biz.ReportBiz;
import com.itpro.model.dao.ReportDao;
import com.itpro.model.dto.report.ReportDto;

@Service
public class ReportBizImpl implements ReportBiz{

	@Autowired
	private ReportDao dao;

	@Override
	public List<ReportDto> selectList() {
		
		return dao.selectList();
	}

	@Override
	public ReportDto selectOne(int report_no) {
		return dao.selectOne(report_no);
	}

	@Override
	public int insert(ReportDto dto) {
		return dao.insert(dto);
	}
	
	

	@Override
	public int getReportCnt() {
		return dao.getReportCnt();
	}

	@Override
	public int insertreportform(ReportDto dto) {
		int res=0;
		
		int insertreportform= dao.insertreportform(dto);
		
		if(insertreportform>0) {
			res=1;
		}
		return res;
	}

	@Override
	public ReportDto select2(int bd_no) {

		return dao.select2(bd_no);
	}
	


}
