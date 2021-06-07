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
import com.itpro.model.dto.board.BoardInsertDto;
import com.itpro.model.dto.project.ProjectInsertDto;
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
			adList = sqlSession.selectList(NAMESPACE + "selectList", adPageMap);

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
			dto = sqlSession.selectOne(NAMESPACE + "selectone", bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<AdDto> adinsert(List<AdDto> adDto, BoardInsertDto boardInsertDto) {

		try {
			int bd_no = sqlSession.insert(NAMESPACE + "boardInsert", boardInsertDto);

			System.out.println("bd_no: " + bd_no);
			System.out.println("bd_no: " + boardInsertDto.getBd_no());

			for (AdDto dto : adDto) {
				
				bd_no = boardInsertDto.getBd_no();

				System.out.println("insert:" + sqlSession.insert(NAMESPACE + "insert", dto));
				System.out.println("dto.ad_no : " + dto.ad_no);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adDto;
	}

	@Override
	public int addelete(int bd_no) {
		int adDeleteRes = 0;
		try {
			adDeleteRes = sqlSession.delete(NAMESPACE + "delete", bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adDeleteRes;
	}

	@Override
	public int update(AdDto dto) {
		int adUpdateRes = 0;
		try {
			adUpdateRes = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return adUpdateRes;
	}

	@Override
	public int getAdListCnt() {
		int adListCnt = 0;
		try {
			adListCnt = Integer.parseInt(
					sqlSession.selectList(NAMESPACE + "selectlistcnt").toString().replace("[", "").replace("]", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adListCnt;
	}

	public int adimageuploadupdate(int ad_no, String ad_file) {
		int result = 0;
		System.out.println("ad_no:" + ad_no);
		System.out.println("ad_file" + ad_file);
		Map<String, Object> adMap = new HashMap<String, Object>();
		adMap.put("ad_no", ad_no);
		adMap.put("ad_file", ad_file);
		System.out.println("adMap parameter: " + new Gson().toJson(adMap));
		try {
			result = sqlSession.update(NAMESPACE + "imageupload", adMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
