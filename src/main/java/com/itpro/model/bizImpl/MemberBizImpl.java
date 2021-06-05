package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.PostLookupDto;
import com.itpro.model.dto.member.ProfileDto;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberDao dao;

	// 회원 탈퇴(삭제)
	@Override
	public String deleteMember(String m_id) {

		return dao.deleteMember(m_id);
	}

	// 탈퇴아이디 체크
	@Override
	public boolean checkPw(String m_id, String m_pw) {

		return dao.checkPw(m_id, m_pw);
	}

	// 회원정보조회
	@Override
	public MemberDto selectOne(int m_no) {

		return dao.selectOne(m_no);
	}

	// 회원정보수정
	@Override
	public int updateMember(MemberDto updateDto) {

		return dao.updateMember(updateDto);
	}

	// 프로필 이미지 업로드
	@Override
	public int profileUpload(ProfileDto profileDto) {

		return dao.profileUpload(profileDto);
	}

	@Override
	public List<PostLookupDto> selectPostLookup(Map<String,Object> map) {
		return dao.selectPostLookup(map);
	}

	@Override
	public int selectPostLookupCnt(Map<String,Object> postLookupPageMap) {
		return dao.selectPostLookupCnt(postLookupPageMap);
	}

}
