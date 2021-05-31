package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.ReportBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dao.ReportDao;
import com.itpro.model.dto.report.ReportDto;




@Service
public class ReportBizImpl implements ReportBiz{

	@Autowired
	private ReportDao dao;
	
	@Autowired
	private ReplyDao replyDao;

	@Autowired
	private LikeDao likeDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<ReportDto> selectList() {
		
		return dao.selectList();
	}

	@Override
	public List<ReportDto> selectList2(int bd_no) {
		return dao.selectList2(bd_no);
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
	

	@Override
	@Transactional
	public int delete(int report_no) {
		int deleteres = 0;
		int replydeleteres = replyDao.deleteWithBoard(report_no);
		int likedeleteres = likeDao.deleteWithBoard(report_no);
		int reportdeleteres = dao.delete(report_no);
		int boarddeleteres = boardDao.delete(report_no);
		if(reportdeleteres>0 && boarddeleteres>0 && replydeleteres>0 && likedeleteres>0) {
			deleteres = 1;
		}
		return deleteres; 
	}

}
