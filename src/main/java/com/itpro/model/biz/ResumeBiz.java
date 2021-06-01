package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.model.dto.resume.ResumeProfileDto;


public interface ResumeBiz {
	
	//이력서 등록
	public MemberDto selectOne();
	
	//이력서 조회
	public ResumeDto resumeDetail(int r_no);

	//이력서 목록 조회
	public List<ResumeDto> resumeList(int m_no);

	//이미지 업로드
	public int profileUpload(ResumeProfileDto resumeProfileDto);



	
	

}
