package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.PortfolioBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.CareerDao;
import com.itpro.model.dao.EducationDao;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dao.MemberDao;
import com.itpro.model.dao.PortfolioDao;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.portfolio.PortfolioDetailDto;
import com.itpro.model.dto.portfolio.PortfolioInsertDto;
import com.itpro.model.dto.portfolio.PortfolioListDto;
import com.itpro.model.dto.portfolio.PortfolioUpdateDto;
import com.itpro.model.dto.resume.CareerDto;

@Service
public class PortfolioBizImpl implements PortfolioBiz{

	
	@Autowired
	private PortfolioDao portfolioDao;

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private ReplyDao replyDao;

	@Autowired
	private LikeDao likeDao;

	
	@Autowired
	private CareerDao careerDao;
	
	@Autowired
	private EducationDao educationDao;
	
	@Autowired
	private MemberDao memberDao;
	
	
	@Override
	public List<PortfolioListDto> selectList(Map<String, Object> portfolioPageMap) {
		return portfolioDao.selectList(portfolioPageMap);
	}

	@Override
	public PortfolioDetailDto selectOne(int bd_no, int m_no) {
		PortfolioDetailDto dto = portfolioDao.selectOne(bd_no);
		dto.setCareer(careerDao.selectOne(m_no));
		dto.setEdu(educationDao.selectOne(m_no));
		dto.setMember(memberDao.selectOne(m_no));
		return dto;
	}

	@Override
	public int portfolioInsert(PortfolioInsertDto portfolioDto) {
		return portfolioDao.portfolioInsert(portfolioDto);
	}

	@Override
	public int delete(int bd_no) {
		int deleteres = 0;
		int replydeleteres = replyDao.deleteWithBoard(bd_no);
		int likedeleteres = likeDao.deleteWithBoard(bd_no);
		int portfoliodeleteres = portfolioDao.delete(bd_no);
		int boarddeleteres = boardDao.delete(bd_no);
		if (portfoliodeleteres > 0 && boarddeleteres > 0 && replydeleteres > 0 && likedeleteres > 0) {
			deleteres = 1;
		}
		return deleteres;
	}

	@Override
	public int update(PortfolioUpdateDto portfolioUpdateDto, BoardUpdateDto boardUpdateDto) {
		int res = 0;
		int portfolioUpdateRes = portfolioDao.update(portfolioUpdateDto);
		int boardUpdateRes = boardDao.update(boardUpdateDto);
		if (portfolioUpdateRes > 0 && boardUpdateRes > 0) {
			res = 1;
		}
		return res;
	}

	@Override
	public int getPortfolioListCnt() {
		return portfolioDao.getPortfolioListCnt();
	}

	@Override
	public PortfolioDetailDto insertForm(int m_no) {
		PortfolioDetailDto dto = new PortfolioDetailDto();
		dto.setEdu(educationDao.selectOne(m_no));
		dto.setCareer(careerDao.selectOne(m_no));
		dto.setMember(memberDao.selectOne(m_no));
		return dto;
	}

	


}
