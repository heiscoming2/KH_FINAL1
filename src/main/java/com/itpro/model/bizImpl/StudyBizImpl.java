package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.StudyBiz;
import com.itpro.model.dao.StudyDao;
import com.itpro.model.dto.study.StudyDetailDto;
import com.itpro.model.dto.study.StudyInsertDto;
import com.itpro.model.dto.study.StudyListDto;

@Service
public class StudyBizImpl implements StudyBiz {
	
	@Autowired
	private StudyDao studyDao;
	
	@Override
	public List<StudyListDto> selectList(Map<String,Object> studyPageMap) {
		return studyDao.selectList(studyPageMap);
	}

	@Override
	public StudyDetailDto selectOne(int bd_no) {
		return studyDao.selectOne(bd_no);
	}

	@Override
	public int studyInsert(StudyInsertDto studyDto) {
		return studyDao.studyInsert(studyDto);
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
		// TODO Auto-generated method stub
		return studyDao.getStudyListCnt();
	}

}
