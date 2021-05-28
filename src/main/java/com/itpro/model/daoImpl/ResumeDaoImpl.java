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
	public int getResumeListCnt() {
		int ResumeListCnt = 0;
		try {
			ResumeListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"selectlistcnt").toString().replace("[","").replace("]", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResumeListCnt;
	}

	@Override
	public List<ResumeDto> selectList(Map<String, Object> resumePageMap) {
		List<ResumeDto> resumeList = null;

		try {
			resumeList = sqlSession.selectList(NAMESPACE + "selectList", resumePageMap);

			System.out.println("projectlist size: " + resumeList.size());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error]: select list");
		}

		return resumeList;
	}

}
