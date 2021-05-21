package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.NoticeDao;
import com.itpro.model.dto.notice.NoticeDto;
import com.itpro.model.dto.notice.NoticeSearchDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(NoticeDaoImpl.class);
	
	@Override
	public List<NoticeDto> selectList(Map<String,Object> noticePageMap) {
		
		List<NoticeDto> noticeList = null;
		try {
			noticeList = sqlSession.selectList(NAMESPACE+"selectlist",noticePageMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public NoticeDto selectOne(int bd_no) {
		NoticeDto dto = null;
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectone",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int noticeInsert(NoticeDto dto) {
		try {
			sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int bd_no) {
		int noticeDeleteRes = 0;
		try {
			noticeDeleteRes = sqlSession.delete(NAMESPACE+"delete",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeDeleteRes;
	}

	@Override
	public int update(NoticeDto dto) {
		int noticeUpdateRes = 0;
		try {
			noticeUpdateRes = sqlSession.update(NAMESPACE+"update",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return noticeUpdateRes;
	}

	@Override
	public int getNoticeListCnt() {
		int NoticeListCnt = 0;
		try {
			NoticeListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"selectlistcnt").toString().replace("[","").replace("]", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NoticeListCnt;
	}

	@Override
	public int getNoticeSearchListCnt(NoticeSearchDto noticeSearchDto) {
		int noticeSearchListCnt = 0;
		try {
			noticeSearchListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"noticesearchlistcnt",noticeSearchDto).toString().replace("[","").replace("]", ""));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return noticeSearchListCnt;
	}

	@Override
	public List<NoticeDto> selectSearchList(Map<String, Object> noticeSearchMap) {
		List<NoticeDto> noticeList = null;
		try {
			noticeList = sqlSession.selectList(NAMESPACE+"selectsearchlist",noticeSearchMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public List<NoticeDto> brandnewNotice(NoticeDto dto) {
		return (List<NoticeDto>) sqlSession.selectList("brandnewNotice", dto);
	}

	


}
