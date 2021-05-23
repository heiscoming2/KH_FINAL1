package com.itpro.model.dao;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;

public interface MemberDao {
	String NAMESPACE = "ItMember.";

	// 회원탈퇴(삭제)
	public String deleteMember(String m_id);

	// 탈퇴 아이디 체크
	public boolean checkPw(String m_id, String m_pw);

	// 회원정보조회
	public MemberDto selectOne(int m_no);

	// 회원정보 수정
	public int updateMember(MemberDto updateDto);

	// 회원프로필 업로드
	public ProfileDto profileUpload(ProfileDto profileDto);

}
