package com.itpro.model.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.PostLookupDto;
import com.itpro.model.dto.member.ProfileDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 회원탈퇴
	@Override
	public String deleteMember(String m_id) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "memberDelete", m_id);

		} catch (Exception e) {
			System.out.println("[error]:memberDelete");
			e.printStackTrace();
		}

		return Integer.toString(res);
	}

	// 탈퇴 아이디 체크
	@Override
	public boolean checkPw(String m_id, String m_pw) {
		boolean res = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_id", m_id);
		map.put("m_pw", m_pw);
		int count = sqlSession.selectOne(NAMESPACE + "checkPw", map);
		if (count == 1) {
			res = true;
		}
		return res;
	}

	// 회원정보 조회
	@Override
	public MemberDto selectOne(int m_no) {
		MemberDto updateDto = null;

		try {
			updateDto = sqlSession.selectOne(NAMESPACE + "selectOne", m_no);

		} catch (Exception e) {
			System.out.println("[error] : select one");
			e.printStackTrace();
		}

		return updateDto;
	}

	// 회원 정보 수정
	@Override
	public int updateMember(MemberDto updateDto) {

		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "update", updateDto);
		} catch (Exception e) {
			System.out.println("[error]:update");
			e.printStackTrace();
		}

		return res;
	}

	// 회원 이미지 업로드
	@Override
	public int profileUpload(ProfileDto profileDto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "uploadProfile", profileDto);
		} catch (Exception e) {
			System.out.println("[error]:uploadProfile");
			e.printStackTrace();
		}

		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	//작성 글 조회
	@Override
	public List<PostLookupDto> selectPostLookup(Map<String,Object> map) {
		List<PostLookupDto> list = null;
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectPostLookup",map);
		} catch (Exception e) {
			log.info("오류 발생 : "+e);
			e.printStackTrace();
		}
				
		return list;
	}
	
	//작성 글 갯수 조회
	@Override
	public int selectPostLookupCnt(Map<String,Object> postLookupPageMap) {
		int res = 0;
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectPostLookupCnt",postLookupPageMap);
		} catch (Exception e) {
			log.info("오류 발생 : "+e);
			e.printStackTrace();
		}
		return res;
	}

}
