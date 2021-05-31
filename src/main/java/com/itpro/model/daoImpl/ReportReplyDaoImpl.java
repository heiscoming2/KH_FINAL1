package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ReportReplyDao;
import com.itpro.model.dto.report.ReportReplyDto;

@Repository
public class ReportReplyDaoImpl implements ReportReplyDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ReportReplyDto> selectList() {
	

		List<ReportReplyDto> list = null;
		
		try {
			list=sqlSession.selectList(NAMESPACE+"selectList");
			System.out.println("list : " +  list);
		} catch (Exception e) {
			System.out.println("[error] : select list");
			e.printStackTrace();
		}
		return list;
	}
	
	
	

	@Override
	public List<ReportReplyDto> selectList2(int re_no) {
		List<ReportReplyDto> list2 =null;
		
		try {
			list2=sqlSession.selectList(NAMESPACE+"selectList2",re_no);
		} catch (Exception e) {
			System.out.println("[error] : select list2");
			e.printStackTrace();
		}
		
		return list2;
	}

	
	

	@Override
	public int insert(ReportReplyDto dto) {
		int res=0;
		
		try {
			res=sqlSession.update(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		return res;
	}


	@Override
	public int insertreportform(ReportReplyDto dto) {
		
		int insertreportform =0;
		
		try {
			insertreportform = sqlSession.update(NAMESPACE+"insertreportform", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertreportform;
	}



	@Override
	public ReportReplyDto select2(int re_no) {
		ReportReplyDto dto =null;
		
		try {
			dto=sqlSession.selectOne(NAMESPACE+"select2",re_no);
		} catch (Exception e) {
			System.out.println("[error] : select one");
			e.printStackTrace();
		}
		
		return dto;
		
	}


	
	
	@Override
	public int delete(int report_reply_no) {
			int report_replyDeleteRes = 0;
			
				try {
					report_replyDeleteRes = sqlSession.delete(NAMESPACE+"delete", report_reply_no);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return report_replyDeleteRes;
	}




	@Override
	public int getReportReplyCnt() {
		// TODO Auto-generated method stub
		return 0;
	}



}
