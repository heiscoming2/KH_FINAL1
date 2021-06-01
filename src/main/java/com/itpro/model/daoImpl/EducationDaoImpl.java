package com.itpro.model.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.EducationDao;
import com.itpro.model.dto.resume.EducationDto;

@Repository
public class EducationDaoImpl implements EducationDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public EducationDto selectOne(int m_no) {
		EducationDto educationDto = null;

		try {
			educationDto = sqlSession.selectOne(NAMESPACE + "selectOne", m_no);

		} catch (Exception e) {
			System.out.println("[error] : select one");
			e.printStackTrace();
		}

		return educationDto;
	}

}
