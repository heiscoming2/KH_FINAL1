package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.KakaoPayDao;
import com.itpro.model.dto.ad.AdDto;
import com.itpro.model.dto.ad.KakaoPayDto;

@Repository
public class KakaoPayDaoImpl implements KakaoPayDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	private Logger logger = LoggerFactory.getLogger(KakaoPayDaoImpl.class);
	

	@Override
	public List<KakaoPayDto> selectList() {
		List<KakaoPayDto> list = null;
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList");
			
			System.out.println("adlist size: " + list.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error]: select list");
		}
		System.out.println(list.toString());
		return list;
		
	}

	

	@Override
	public int insert(KakaoPayDto dto) {
		int res = 0;
		try {
		 res = sqlSession.insert(NAMESPACE+"insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int pay_seq) {
		int kakaoDeleteRes = 0;
		try {
			kakaoDeleteRes = sqlSession.delete(NAMESPACE+"delete",pay_seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kakaoDeleteRes;
	}



	@Override
	public int adStatusChange(int bd_no) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"adStatusChange",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	

	




}
