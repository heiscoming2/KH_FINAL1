package com.itpro.model.biz;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;

public interface MemberBiz {
	// 회원탈퇴(삭제)
	public String deleteMember(String m_id);

	// 회원삭제 비밀번호 체크
	public boolean checkPw(String m_id, String m_pw);

	// 회원정보조회
	public MemberDto selectOne(int m_no);

	// 회원 정보 수정
	public int updateMember(MemberDto updateDto);

	// 프로필 이미지 업로드
	public ProfileDto profileUpload(ProfileDto profileDto);

}
