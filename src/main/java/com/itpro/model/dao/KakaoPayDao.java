package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import com.itpro.model.dto.ad.KakaoPayDto;

public interface KakaoPayDao {

	
	String NAMESPACE = "KakaoPay.";

	public List<KakaoPayDto> selectList();
	public int insert(KakaoPayDto dto);
	public int delete(int pay_seq);

}
