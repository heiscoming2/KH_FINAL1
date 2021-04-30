package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.StudyBiz;
import com.itpro.model.dao.StudyDao;
import com.itpro.model.dto.StudyDto;
import com.itpro.model.dto.StudyListDto;

@Service
public class StudyBizImpl implements StudyBiz {
	
	@Autowired
	private StudyDao studyDao;
	
	@Override
	public List<StudyListDto> selectList() {
		return studyDao.selectList();
	}

	@Override
	public StudyDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(StudyDto studyDto) {
		return studyDao.insert(studyDto);
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
