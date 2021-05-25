package com.itpro.model.biz;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;

public interface ResumeBiz {

	//이력서 등록
	MemberDto selectOne(int m_no);
	

}
