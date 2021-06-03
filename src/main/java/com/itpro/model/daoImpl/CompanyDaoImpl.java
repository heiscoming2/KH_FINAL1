package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.CompanyDao;
import com.itpro.model.dto.company.CompanyResumeDto;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Map<String, Integer> map) {
		int res = 0;
		try {
			res= sqlSession.insert(NAMESPACE+"insert",map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<CompanyResumeDto> selectCompanyResumeList(int m_no) {
		List<CompanyResumeDto> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"selectCompanyResumeList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateStatusChange(Map<String, Object> map) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"updatestatuschange",map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
