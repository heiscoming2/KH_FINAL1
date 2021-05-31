package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.biz.ResumeBiz;
import com.itpro.model.dao.MemberDao;
import com.itpro.model.dao.ResumeDao;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.model.dto.resume.ResumeProfileDto;

@Service
public class ResumeBizImpl implements ResumeBiz {

	@Autowired
	private ResumeDao dao;


	//이력서 등록
	@Override
	public MemberDto selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

	//이력서 조회
	@Override
	public List<ResumeDto> resumeList(int m_no) {
		
		return dao.resumeList(m_no);
	}

	//이미지 저장
	@Override
	public int profileUpload(ResumeProfileDto resumeProfileDto) {
		
		return dao.profileUpload(resumeProfileDto);
	}

	
	

	
	

	

}
