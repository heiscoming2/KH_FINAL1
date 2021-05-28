package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.StudyDao;
import com.itpro.model.dto.study.StudyDetailDto;
import com.itpro.model.dto.study.StudyInsertDto;
import com.itpro.model.dto.study.StudyJoinInfoDto;
import com.itpro.model.dto.study.StudyListDto;
import com.itpro.model.dto.study.StudySearchDto;
import com.itpro.model.dto.study.StudyUpdateDto;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StudyDaoImpl implements StudyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
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
	public int studyInsert(StudyInsertDto studyDto) {
		try {
			sqlSession.insert(NAMESPACE+"insert",studyDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int bd_no) {
		int studyDeleteRes = 0;
		try {
			studyDeleteRes = sqlSession.delete(NAMESPACE+"delete",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studyDeleteRes;
	}

	@Override
	public int update(StudyUpdateDto studyUpdateDto) {
		int studyUpdateRes = 0;
		try {
			studyUpdateRes = sqlSession.update(NAMESPACE+"update",studyUpdateDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studyUpdateRes;
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

	@Override
	public int getStudySearchListCnt(StudySearchDto studySearchDto) {
		int studySearchListCnt = 0;
		try {
			studySearchListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"studysearchlistcnt",studySearchDto).toString().replace("[","").replace("]", ""));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return studySearchListCnt;
	}

	@Override
	public List<StudyListDto> selectSearchList(Map<String, Object> studySearchMap) {
		List<StudyListDto> studyList = null;
		try {
			studyList = sqlSession.selectList(NAMESPACE+"selectsearchlist",studySearchMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studyList;
	}

	@Override
	public int updatestatus(int bd_no) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"updatestatus",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dao"+bd_no);
		return res;
	}

	@Override
	public int studyJoinApplyInsert(StudyJoinInfoDto studyJoinInfoDto) {
		log.info("studyJoinApplyInsert DaoImpl");
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"studyjoinapplyinsert",studyJoinInfoDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int studyJoinApplySelectOne(StudyJoinInfoDto studyJoinInfoDto) {
		log.info("studyJoinApplySelectOne DaoImpl");
		int res = 0;
		try {
			res = sqlSession.selectOne(NAMESPACE+"studyjoinapplyselectone",studyJoinInfoDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<StudyJoinInfoDto> studyJoinInfoSelectList(int bd_no) {
		log.info("studyJoinInfoSelectListCnt DaoImpl");
		List<StudyJoinInfoDto> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"studyjoininfoselectlistcnt",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<StudyJoinInfoDto> studyJoinInfoSelectList(StudyJoinInfoDto studyJoinInfodto) {
		log.info("studyJoinInfoSelectList DaoImpl");
		List<StudyJoinInfoDto> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE+"studyjoininfoselectlist",studyJoinInfodto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
