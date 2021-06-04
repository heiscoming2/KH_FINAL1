package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.KakaoPayBiz;
import com.itpro.model.dao.KakaoPayDao;
import com.itpro.model.dto.ad.KakaoPayDto;

import lombok.extern.java.Log;



@Service
@Log
public class KakaoPayBizImple implements KakaoPayBiz {

	@Autowired
	KakaoPayDao dao;


public List<KakaoPayDto> selectList() {
		return dao.selectList();
	}

	@Override
	public int insert(KakaoPayDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int delete(int pay_seq) {
		return dao.delete(pay_seq);
	}

	
}
