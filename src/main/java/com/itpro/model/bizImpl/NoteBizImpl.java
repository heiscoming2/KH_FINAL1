package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

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
	public List<NoteDto> receiveList(int n_receiver) {

		return dao.receiveList(n_receiver);
	}

	// 보낸쪽지 목록
	@Override
	public List<NoteDto> sendList(int n_sender) {

		return dao.sendList(n_sender);
	}

	// 새로 받은 쪽지가 있는지 확인(매번)
	@Override
	public Integer countNewNote() {
		return dao.countNewNote();
	}

	// 내가 받은쪽지 하나 읽기
	@Override
	public NoteDto receiveDetail(Map map) {

		return dao.receiveDetail(map);
	}

	// 읽은 쪽지 읽은 시간 표시 UPDATE
	@Override
	public int updateReadDate() {

		return dao.updateReadDate();
	}

	// 보낸 쪽지 하나 읽기
	@Override
	public NoteDto sendDetail() {

		return dao.sendDetail();
	}

	// 쪽지 보내기
	@Override
	public int noteSend(NoteDto noteDto) {

		return dao.noteSend(noteDto);
	}
}
