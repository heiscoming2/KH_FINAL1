package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.PortfolioBiz;
import com.itpro.model.dao.PortfolioDao;
import com.itpro.model.dto.PortfolioDto;

@Service
public class PortfolioBizImpl implements PortfolioBiz{

	@Autowired
	private PortfolioDao PortfolioDaoImpl;

	@Override
	public List<PortfolioDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PortfolioDto selectOne(int bd_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(PortfolioDto portfolioDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	


}
