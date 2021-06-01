package com.itpro.model.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

@Repository
public class ResumeDaoImpl implements ResumeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 이력서 등록
	@Override
	public MemberDto selectOne(int m_no) {

		return null;
	}

	// 이력서 목록 조회
	@Override
	public List<ResumeDto> resumeList(int m_no) {
		List<ResumeDto> list = new ArrayList<ResumeDto>(m_no);

		try {
			list = sqlSession.selectList(NAMESPACE + "resumeList", m_no);

		} catch (Exception e) {
			System.out.println("[error] : resumeList");
			e.printStackTrace();
		}

		return list;
	}

	// 이력서 기본정보 조회(detail)
	@Override
	public ResumeDetailDto resumeDetail(int r_no) {
		ResumeDetailDto resumeDto = null;

		try {
			resumeDto = sqlSession.selectOne(NAMESPACE + "resumeDetail", r_no);

		} catch (Exception e) {
			System.out.println("[error] : resumeDetail");
			e.printStackTrace();
		}

		return resumeDto;
	}

	// 이력서 학력사항 조회(list)
	@Override
	public List<EducationDto> educationList(int m_no) {
		List<EducationDto> list = new ArrayList<>();

		try {
			list = sqlSession.selectList(NAMESPACE + "educationList", m_no);

		} catch (Exception e) {
			System.out.println("[error] : educationList");
			e.printStackTrace();
		}

		return list;
	}
	
	// 이력서 자격사항(list)
	@Override
	public List<LicenceDto> licenceList(int m_no) {
		List<LicenceDto> list = new ArrayList<>();

		try {
			list = sqlSession.selectList(NAMESPACE + "licenceList", m_no);

		} catch (Exception e) {
			System.out.println("[error] : licenceList");
			e.printStackTrace();
		}

		return list;
	}
	
	// 이력서 경력사항(list)
	@Override
	public List<CareerDto> careerList(int m_no) {
		List<CareerDto> list = new ArrayList<>();

		try {
			list = sqlSession.selectList(NAMESPACE + "careerList", m_no);

		} catch (Exception e) {
			System.out.println("[error] : careerList");
			e.printStackTrace();
		}

		return list;
	}


	// 이력서 이미지 등록
	@Override
	public int profileUpload(ResumeProfileDto resumeProfileDto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "uploadProfile", resumeProfileDto);
		} catch (Exception e) {
			System.out.println("[error]:uploadProfile");
			e.printStackTrace();
		}

		return res;
	}

	// 이력서 삭제
	@Override
	public int resumeDelete(int r_no) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "resumeDelete", r_no);
		} catch (Exception e) {
			System.out.println("[error]:resume delete");
			e.printStackTrace();
		}

		return res;
	}


}
