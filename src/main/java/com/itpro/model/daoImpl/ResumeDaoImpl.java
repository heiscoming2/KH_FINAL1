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
import com.itpro.model.dto.resume.ResumeImgDto;
import com.itpro.model.dto.resume.ResumeProfileDto;
import com.itpro.model.dto.resume.ResumeUploadDto;

@Repository
public class ResumeDaoImpl implements ResumeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 이력서 목록 조회
	@Override
	public List<ResumeDto> resumeList(int m_no) {
		List<ResumeDto> list = new ArrayList<ResumeDto>();

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

	// 이력서 자격사항 조회(list)
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

	// 이력서 경력사항 조회(list)
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

	// 이력서 이미지 업로드
	public int uploadResumeImg(ResumeImgDto resumeImgDto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "uploadResumeImg", resumeImgDto);
		} catch (Exception e) {
			System.out.println("[error]:uploadResumeImg");
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

	// =============== 이력서 등록 ==========================

	// 이력서 - 회원 기본 정보 수정
	// 중요: 이력서에서 회원 기본 정보를 수정할 때 사용하는 쿼리로
	// 회원 정보에서 회원 기본 정보를 수정할 때는 이 쿼리를 사용하지 말아주세요.
	@Override
	public int memResumeUpdate(MemberDto memberDto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "memResumeUpdate", memberDto);
		} catch (Exception e) {
			System.out.println("[error]:memResumeUpdate");
			e.printStackTrace();
		}

		return res;
	}

	// 이력서 기본 정보 입력
	@Override
	public int resumeInsert(ResumeUploadDto dto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "resumeInsert", dto);

		} catch (Exception e) {
			System.out.println("[error] : resumeInsert");
			e.printStackTrace();
		}

		return res;
	}

	// 이력서 기본정보 수정
	@Override
	public int resumeUpdate(ResumeDetailDto dto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "resumeUpdate", dto);
		} catch (Exception e) {
			System.out.println("[error]:resumeUpdate");
			e.printStackTrace();
		}

		return res;
	}
	
	

	// 이력서 학력사항 정보 입력
	@Override
	public int educationInsert(EducationDto educationDto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "educationInsert", educationDto);

		} catch (Exception e) {
			System.out.println("[error] : educationInsert");
			e.printStackTrace();
		}

		return res;
	}

	// 이력서 학력사항 정보 수정
	public int educationUpdate(EducationDto educationDto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "educationUpdate", educationDto);
		} catch (Exception e) {
			System.out.println("[error]:educationUpdate");
			e.printStackTrace();
		}

		return res;
	}

	// 이력서 학력사항 정보 삭제
	public int educationDelete(EducationDto educationDto) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "educationDelete", educationDto);
		} catch (Exception e) {
			System.out.println("[error]:educationDelete");
			e.printStackTrace();
		}

		return res;
	}
	
	

	// 이력서 자격사항 정보 입력
	@Override
	public int licenceInsert(LicenceDto licenceDto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "licenceInsert", licenceDto);

		} catch (Exception e) {
			System.out.println("[error] : licenceInsert");
			e.printStackTrace();
		}

		return res;
	}

	// 이력서 자격사항 정보 수정
	@Override
	public int licenceUpdate(LicenceDto licenceDto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "licenceUpdate", licenceDto);
		} catch (Exception e) {
			System.out.println("[error]:licenceUpdate");
			e.printStackTrace();
		}

		return res;
	}

	// 이력서 자격사항 정보 삭제
	@Override
	public int licenceDelete(LicenceDto licenceDto) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "licenceDelete", licenceDto);
		} catch (Exception e) {
			System.out.println("[error]:licenceDelete");
			e.printStackTrace();
		}

		return res;
	}
	
	

	// 이력서 경력사항 정보 입력
	@Override
	public int careerInsert(CareerDto careerDto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "careerInsert", careerDto);

		} catch (Exception e) {
			System.out.println("[error] : careerInsert");
			e.printStackTrace();
		}

		return res;
	}

	// 이력서 자격사항 정보 수정
	@Override
	public int careerUpdate(CareerDto careerDto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "careerUpdate", careerDto);
		} catch (Exception e) {
			System.out.println("[error]:careerUpdate");
			e.printStackTrace();
		}

		return res;
	}

	// 이력서 자격사항 정보 삭제
	@Override
	public int careerDelete(CareerDto careerDto) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "careerDelete", careerDto);
		} catch (Exception e) {
			System.out.println("[error]:careerDelete");
			e.printStackTrace();
		}

		return res;
	}

}
