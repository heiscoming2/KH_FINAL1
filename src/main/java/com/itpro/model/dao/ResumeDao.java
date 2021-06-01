package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.resume.EducationDto;
import com.itpro.model.dto.resume.ResumeDetailDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.model.dto.resume.ResumeProfileDto;

public interface ResumeDao {
	String NAMESPACE = "Resume.";

	//이력서 조회
	public List<ResumeDto> resumeList(int m_no);

	//이력서 기본정보 조회(detail)
	public ResumeDetailDto resumeDetail(int r_no);
	
	//이력서 학력사항 조회(list)
	public List<EducationDto> educationList(int m_no);
	
	// 이력서 등록
	public MemberDto selectOne(int m_no);
	
	//이력서 이미지 업로드
	public int profileUpload(ResumeProfileDto resumeProfileDto);

	//이력서 삭제
	public int resumeDelete(int r_no);

	

	

}
