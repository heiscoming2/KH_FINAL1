package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.CareerDao;
import com.itpro.model.dto.resume.CareerDto;

@Repository
public class CareerDaoImpl implements CareerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CareerDto> selectOne(int m_no) {
		List<CareerDto> careerDto = null;

		try {
			careerDto = sqlSession.selectList(NAMESPACE + "selectOne", m_no);

		} catch (Exception e) {
			System.out.println("[error] : select one");
			e.printStackTrace();
		}

		return careerDto;
	}

}
