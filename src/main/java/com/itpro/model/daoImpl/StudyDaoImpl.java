package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.StudyDao;
import com.itpro.model.dto.StudyDetailDto;
import com.itpro.model.dto.StudyDto;
import com.itpro.model.dto.StudyListDto;

@Repository
public class StudyDaoImpl implements StudyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(StudyDaoImpl.class);
	
	@Override
	public List<StudyListDto> selectList(Map<String,Object> studyPageMap) {
		
		List<StudyListDto> studyList = null;
		try {
			studyList = sqlSession.selectList(NAMESPACE+"selectlist",studyPageMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studyList;
	}

	@Override
	public StudyDetailDto selectOne(int bd_no) {
		StudyDetailDto studyDetailDto = null;
		try {
			studyDetailDto = sqlSession.selectOne(NAMESPACE+"selectone",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studyDetailDto;
	}

	@Override
	public int studyInsert(StudyDto studyDto) {
		try {
			sqlSession.insert(NAMESPACE+"insert",studyDto);
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

	@Override
	public int getStudyListCnt() {
		int StudyListCnt = 0;
		try {
			StudyListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"selectlistcnt").toString().replace("[","").replace("]", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StudyListCnt;
	}

}
