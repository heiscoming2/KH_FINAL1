package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.resume.ResumeDto;

public interface ResumeDao {
	String NAMESPACE = "Resume.";

	// 이력서 조회
	public int getResumeListCnt();
	public List<ResumeDto> selectList(Map<String, Object> resumePageMap);

	// 이력서 등록
	public MemberDto selectOne(int m_no);

	

	

}
