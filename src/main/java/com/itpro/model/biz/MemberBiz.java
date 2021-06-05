package com.itpro.model.biz;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.PostLookupDto;
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
	public int profileUpload(ProfileDto profileDto);
	
	
	
	
	//작성글 목록
	public List<PostLookupDto> selectPostLookup(Map<String,Object> map);
	
	//작성글 갯수
	public int selectPostLookupCnt(Map<String,Object> postLookupPageMap);
	

}
