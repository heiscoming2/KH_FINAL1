package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.ad.KakaoPayDto;

public interface KakaoPayBiz {
	public List<KakaoPayDto> selectList();
	public int insert(KakaoPayDto dto);
	public int delete(int pay_seq);
	public int adStatusChange(int bd_no);
}
