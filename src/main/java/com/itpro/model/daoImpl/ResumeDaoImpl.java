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

	// 이력서 조회
	@Override
	public List<ResumeDto> resumeList(int m_no) {
		List<ResumeDto> list = new ArrayList<ResumeDto>(m_no);

		try {
			list = sqlSession.selectList(NAMESPACE + "resumeList", m_no);

		} catch (Exception e) {
			System.out.println("[error] : select list");
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

}
