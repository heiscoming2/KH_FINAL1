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
	public ReportDto selectOne(int report_no) {
		ReportDto dto =null;
		
		try {
			dto=sqlSession.selectOne(NAMESPACE+"selectOne",report_no);
		} catch (Exception e) {
			System.out.println("[error] : select one");
			e.printStackTrace();
		}
		
		return dto;
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





}