package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.model.dto.resume.ResumeProfileDto;

public interface ResumeDao {
	String NAMESPACE = "Resume.";

	// 이력서 조회
	public List<ResumeDto> resumeList(int m_no);

	//이력서 조회
	public ResumeDto resumeDetail(int r_no);
	
	// 이력서 등록
	public MemberDto selectOne(int m_no);
	
	//이력서 이미지 업로드
	public int profileUpload(ResumeProfileDto resumeProfileDto);

	//이력서 삭제
	public int resumeDelete(int r_no);

	

	

}
