package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.resume.ResumeDto;


public interface ResumeBiz {
	
	//이력서 등록
	public MemberDto selectOne(int m_no);

	//이력서 목록 조회
	public int getResumeListCnt();
	public List<ResumeDto> selectList(Map<String, Object> resumePageMap);



	
	

}
