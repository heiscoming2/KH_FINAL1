package com.itpro.model.bizImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.biz.ResumeBiz;
import com.itpro.model.dao.MemberDao;
import com.itpro.model.dao.ResumeDao;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.resume.ResumeDto;

@Service
public class ResumeBizImpl implements ResumeBiz {

	@Autowired
	private ResumeDao dao;
	
	//이력서 목록조회
	@Override
	public List<ResumeDto> selectList(int m_no) {
		
		return dao.selectList(m_no);
	}

	//이력서 등록
	@Override
	public MemberDto selectOne(int m_no) {
		
		return dao.selectOne(m_no);
	}

	

	

}
