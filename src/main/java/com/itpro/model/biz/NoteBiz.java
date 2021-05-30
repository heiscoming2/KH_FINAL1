package com.itpro.model.biz;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.note.NoteDto;
import com.itpro.model.dto.resume.ResumeDto;


public interface NoteBiz {

	// 내가 받은 쪽지 목록 조회
	public List<NoteDto> receiveList();

	// 새로 받은 쪽지가 있는지 확인(매번)
	public Integer countNewNote();
}
