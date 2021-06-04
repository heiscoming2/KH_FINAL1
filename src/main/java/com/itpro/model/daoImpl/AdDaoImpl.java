package com.itpro.model.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.itpro.model.dao.AdDao;
import com.itpro.model.dto.ad.AdDto;
import com.itpro.model.dto.qna.QnaDetailDto;
import com.itpro.model.dto.qna.QnaInsertDto;
import com.itpro.model.dto.qna.QnaUpdateDto;

@Repository
public class AdDaoImpl implements AdDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	private Logger logger = LoggerFactory.getLogger(AdDaoImpl.class);
	

	@Override
	public List<AdDto> selectList(Map<String, Object> adPageMap) {
		List<AdDto> adList = null;
		
		try {
			adList = sqlSession.selectList(NAMESPACE+"selectList", adPageMap);
			
			System.out.println("adlist size: " + adList.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error]: select list");
		}
		System.out.println(adList.toString());
		return adList;
		
	}

	@Override
	public AdDto selectOne(int bd_no) {
		AdDto dto = null;
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectone", bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(AdDto dto) {
		int res = 0;
		try {
		 res = sqlSession.insert(NAMESPACE+"insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int bd_no) {
		int adDeleteRes = 0;
		try {
			adDeleteRes = sqlSession.delete(NAMESPACE+"delete",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adDeleteRes;
	}

	@Override
	public int update(AdDto dto) {
		int adUpdateRes = 0;
		try {
			adUpdateRes = sqlSession.update(NAMESPACE+"update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return adUpdateRes;
	}

	@Override
	public int getAdListCnt() {
		int adListCnt = 0;
		try {
			adListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"selectlistcnt").toString().replace("[","").replace("]", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adListCnt;
	}

	
	
	public int imageuploadupdate(int ad_seq, String ad_file) {
		int result = 0;
		System.out.println("ad_seq:" + ad_seq);
		System.out.println("pro_file" + ad_file);
		Map<String, Object> projectMap = new HashMap<String, Object>();
		projectMap.put("ad_seq", ad_seq);
		projectMap.put("pro_file", ad_file);
		System.out.println("projectMap parameter: " + new Gson().toJson(projectMap));
		try {
		result = sqlSession.update(NAMESPACE + "imageupload", projectMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result; 
	}

	



}
