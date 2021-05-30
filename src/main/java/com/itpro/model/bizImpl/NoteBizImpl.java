package com.itpro.model.bizImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.MemberBiz;
import com.itpro.model.biz.NoteBiz;
import com.itpro.model.biz.ResumeBiz;
import com.itpro.model.dao.MemberDao;
import com.itpro.model.dao.NoteDao;
import com.itpro.model.dao.ResumeDao;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.note.NoteDto;
import com.itpro.model.dto.resume.ResumeDto;

@Service
public class NoteBizImpl implements NoteBiz {

	@Autowired
	private NoteDao dao;

	// 내가 받은 쪽지 목록 조회
	@Override
	public List<NoteDto> receiveList() {
		return dao.receiveList();
	}

	@Override
	// 새로 받은 쪽지가 있는지 확인(매번)
	public Integer countNewNote() {
		return dao.countNewNote();
	}
}
