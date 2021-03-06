package com.itpro.model.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.resume.CareerDto;
import com.itpro.model.dto.resume.EducationDto;
import com.itpro.model.dto.resume.LicenceDto;
import com.itpro.model.dto.resume.ResumeDetailDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.model.dto.resume.ResumeImgDto;
import com.itpro.model.dto.resume.ResumeProfileDto;
import com.itpro.model.dto.resume.ResumeUploadDto;

public interface ResumeDao {
	String NAMESPACE = "Resume.";

	// 이력서 조회
	public List<ResumeDto> resumeList(int m_no);

	// 이력서 기본정보 조회(detail)
	public ResumeDetailDto resumeDetail(int r_no);

	// 이력서 학력사항 조회(list)
	public List<EducationDto> educationList(int m_no);

	// 이력서 자격사항 조회(list)
	public List<LicenceDto> licenceList(int m_no);

	// 이력서 경력사항 조회(list)
	public List<CareerDto> careerList(int m_no);

	// 이력서 이미지 업로드
	public int uploadResumeImg(ResumeImgDto resumeImgDto);

	// 이력서 삭제
	public int resumeDelete(int r_no);

	// 이력서 - 회원 기본 정보 수정
	public int memResumeUpdate(MemberDto memberDto);

	// 이력서 기본 정보 입력
	public int resumeInsert(ResumeUploadDto dto);

	// 이력서 기본정보 수정
	public int resumeUpdate(ResumeDetailDto dto);

	
	// 이력서 학력사항 정보 입력
	public int educationInsert(EducationDto educationDto);

	// 이력서 학력사항 정보 수정
	public int educationUpdate(EducationDto educationDto);

	// 이력서 학력사항 정보 삭제
	public int educationDelete(EducationDto educationDto);
	
	

	// 이력서 자격사항 정보 입력
	public int licenceInsert(LicenceDto licenceDto);

	// 이력서 자격사항 정보 수정
	public int licenceUpdate(LicenceDto licenceDto);

	// 이력서 자격사항 정보 삭제
	public int licenceDelete(LicenceDto licenceDto);
	
	

	// 이력서 경력사항 정보 입력
	public int careerInsert(CareerDto careerDto);

	// 이력서 경력사항 정보 수정
	public int careerUpdate(CareerDto careerDto);

	// 이력서 경력사항 정보 삭제
	public int careerDelete(CareerDto careerDto);

}
