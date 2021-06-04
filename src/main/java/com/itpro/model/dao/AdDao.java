package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.itpro.model.dto.ad.AdDto;
import com.itpro.model.dto.qna.QnaUpdateDto;

public interface AdDao {

	
	String NAMESPACE = "Ad.";

	public List<AdDto> selectList(Map<String,Object> adPageMap);
	public AdDto selectOne(int bd_no);
	public int insert(AdDto dto);
	public int delete(int bd_no);
	public int update(AdDto dto);
	public int getAdListCnt();
	public int imageuploadupdate(MultipartFile fileName, int ad_seq);
}
