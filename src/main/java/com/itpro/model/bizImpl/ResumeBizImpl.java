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
import com.itpro.model.dto.resume.CareerDto;
import com.itpro.model.dto.resume.EducationDto;
import com.itpro.model.dto.resume.LicenceDto;
import com.itpro.model.dto.resume.ResumeDetailDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.model.dto.resume.ResumeProfileDto;

@Service
public class ResumeBizImpl implements ResumeBiz {

	@Autowired
	private ResumeDao dao;

	// 이력서 목록조회
	@Override
	public List<ResumeDto> resumeList(int m_no) {

		return dao.resumeList(m_no);
	}

	// 이력서 기본정보 조회(detail)
	@Override
	public ResumeDetailDto resumeDetail(int r_no) {
		return dao.resumeDetail(r_no);
	}

	// 이력서 학력사항 조회(list)
	@Override
	public List<EducationDto> educationList(int m_no) {
		return dao.educationList(m_no);
	}

	// 이력서 자격사항 조회(list)
	public List<LicenceDto> licenceList(int m_no) {
		return dao.licenceList(m_no);
	}

	// 이력서 경력사항 조회(list)
	public List<CareerDto> careerList(int m_no) {
		return dao.careerList(m_no);
	}

	// 이미지 저장
	@Override
	public int profileUpload(ResumeProfileDto resumeProfileDto) {

		return dao.profileUpload(resumeProfileDto);
	}

	// 이력서 삭제
	@Override
	public int resumeDelete(int r_no) {
		return dao.resumeDelete(r_no);
	}

	// 이력서 - 회원 기본 정보 수정
	@Override
	public int memResumeUpdate(MemberDto memberDto) {
		
		return dao.memResumeUpdate(memberDto);
	}

	// 이력서 기본 정보 입력
	@Override
	public int resumeInsert(ResumeDetailDto resumeDto) {
		
		return dao.resumeInsert(resumeDto);
	}

	// 이력서 경력사항 정보 입력
	@Override
	public int careerInsert(CareerDto careerDto) {
		
		return dao.careerInsert(careerDto);
	}

	// 이력서 학력사항 정보 입력
	@Override
	public int educationInsert(EducationDto educationDto) {
		
		return dao.educationInsert(educationDto);
	}

	// 이력서 자격사항 정보 입력
	@Override
	public int licenseInsert(LicenceDto licenceDto) {
		
		return dao.licenseInsert(licenceDto);
	}

}
