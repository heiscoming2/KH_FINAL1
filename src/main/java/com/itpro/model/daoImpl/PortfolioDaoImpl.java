package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.PortfolioDao;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.portfolio.PortfolioDetailDto;
import com.itpro.model.dto.portfolio.PortfolioInsertDto;
import com.itpro.model.dto.portfolio.PortfolioListDto;
import com.itpro.model.dto.portfolio.PortfolioUpdateDto;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class PortfolioDaoImpl implements PortfolioDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	private Logger logger = LoggerFactory.getLogger(PortfolioDaoImpl.class);
	
	
	
	@Override
	public List<PortfolioListDto> selectList(Map<String, Object> portfolioPageMap) {
		List<PortfolioListDto> portfolioList = null;
		
		try {
			portfolioList = sqlSession.selectList(NAMESPACE+"selectList", portfolioPageMap);
			
			System.out.println("portfoliolist size: " + portfolioList.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error]: select list");
		}
		System.out.println(portfolioList.toString());
		return portfolioList;
	}

	@Override
	public PortfolioDetailDto selectOne(int bd_no) {
		PortfolioDetailDto portfolioDetailDto = null;
		try {
			portfolioDetailDto = sqlSession.selectOne(NAMESPACE+"selectone", bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//log.info("portfolioDetailDto daoimpl: " + portfolioDetailDto.toString());
		
		return portfolioDetailDto;
	}

	@Override
	public int portfolioInsert(PortfolioInsertDto portfolioDto) {
		int res = 0;
		try {
		 res = sqlSession.insert(NAMESPACE+"insert", portfolioDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}


	@Override
	public int delete(int bd_no) {
		int portfolioDeleteRes = 0;
		try {
			portfolioDeleteRes = sqlSession.delete(NAMESPACE+"delete",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return portfolioDeleteRes;
	}

	@Override
	public int update(PortfolioUpdateDto portfolioUpdateDto) {
		int portfolioUpdateRes = 0;

		try {
			portfolioUpdateRes = sqlSession.update(NAMESPACE+"update", portfolioUpdateDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return portfolioUpdateRes;
	}

	@Override
	public int getPortfolioListCnt(Map<String, Object> portfolioPageMap) {
		int portfolioListCnt = 0;
		try {
			portfolioListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"selectlistcnt",portfolioPageMap).toString().replace("[","").replace("]", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return portfolioListCnt;
	}


}
