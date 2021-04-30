package com.itpro.model.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.StudyDao;
import com.itpro.model.dto.StudyDto;
import com.itpro.model.dto.StudyListDto;

@Repository
public class StudyDaoImpl implements StudyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<StudyListDto> selectList() {
		
		List<StudyListDto> studyList = null;
		try {
			studyList = sqlSession.selectList(NAMESPACE+"selectstudylist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studyList;
	}

	@Override
	public StudyDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(StudyDto studyDto) {
		try {
			sqlSession.insert(NAMESPACE+"studyinsert",studyDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

}
