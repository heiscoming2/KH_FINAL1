package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.ReportReplyBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dao.ReportDao;
import com.itpro.model.dao.ReportReplyDao;
import com.itpro.model.dto.report.ReportReplyDto;

@Service
public class ReportReplyBizImpl implements ReportReplyBiz{

	@Autowired
	private ReportReplyDao dao;

	@Autowired
	private ReportDao reportdao;
	
	@Autowired
	private ReplyDao replyDao;

	@Autowired
	private LikeDao likeDao;
	
	@Autowired
	private BoardDao boardDao;
	
	
	
	@Override
	public List<ReportReplyDto> selectList() {
		return dao.selectList();
	}

	@Override
	public ReportReplyDto selectOne(int report_reply_no) {
		return dao.selectOne(report_reply_no);
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

	@Override
	@Transactional
	public int delete(int report_reply_no) {
		int deleteres = 0;
		int replydeleteres = replyDao.deleteWithBoard(report_reply_no);
		int report_replydeleteres = dao.delete(report_reply_no);
		if(report_replydeleteres>0&& replydeleteres>0 ) {
			deleteres = 1;
		}
		return deleteres; 
	}
	
	
	

}
