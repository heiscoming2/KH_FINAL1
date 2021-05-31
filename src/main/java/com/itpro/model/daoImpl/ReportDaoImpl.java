package com.itpro.model.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ReportDao;
import com.itpro.model.dto.report.ReportDto;

@Repository
public class ReportDaoImpl implements ReportDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ReportDto> selectList() {
	

		List<ReportDto> list = null;
		
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
	public List<ReportDto> selectList2(int bd_no) {
		
		List<ReportDto> list2 =null;
		
		try {
			list2=sqlSession.selectList(NAMESPACE+"selectList2",bd_no);
		} catch (Exception e) {
			System.out.println("[error] : select one");
			e.printStackTrace();
		}
		
		return list2;
	}

	
	

	@Override
	public int insert(ReportDto dto) {
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
	public int getReportCnt() {
		int ReportCnt = 0;
		try {
			ReportCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"reportcnt").toString().replace("[","").replace("]", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReportCnt;

	}



	@Override
	public int insertreportform(ReportDto dto) {
		
		int insertreportform =0;
		
		try {
			insertreportform = sqlSession.update(NAMESPACE+"insertreportform", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertreportform;
	}



	@Override
	public ReportDto select2(int bd_no) {
		ReportDto dto =null;
		
		try {
			dto=sqlSession.selectOne(NAMESPACE+"select2",bd_no);
		} catch (Exception e) {
			System.out.println("[error] : select one");
			e.printStackTrace();
		}
		
		return dto;
		
	}
	
	@Override
	public int delete(int report_no) {
		int reportDeleteRes = 0;
		
			try {
				reportDeleteRes = sqlSession.delete(NAMESPACE+"delete", report_no);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return reportDeleteRes; 
	}


}
