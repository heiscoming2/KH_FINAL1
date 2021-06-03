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

	// 내가 받은쪽지 하나 읽기
	@Override
	public NoteDto receiveDetail(Map map) {

		return dao.receiveDetail(map);
	}

	// 보낸 쪽지 하나 읽기
	@Override
	public NoteDto sendDetail(Map map) {

		return dao.sendDetail(map);
	}

	// 쪽지 보내기
	@Override
	public int noteSend(NoteDto noteDto) {

		return dao.noteSend(noteDto);
	}

	// 쪽지 삭제
	@Override
	public int noteDelete(int n_no) {
		
		return dao.noteDelete(n_no);
	}

	// 읽은 쪽지 읽은 시간 표시 UPDATE
	@Override
	public int updateReadDate() {

		return dao.updateReadDate();
	}

	// 새로 받은 쪽지가 있는지 확인(매번)
	@Override
	public Integer countNewNote() {
		return dao.countNewNote();
	}

	@Override
	public int companyApplicationSendNote(Map<String, Object> map) {
		String n_title="지원하신 채용 정보에 대한 결과입니다.";
		String n_content="";
		if(map.get("ca_status").toString().charAt(0)=='Y') {
			n_content="서류 합격";
		} else {
			n_content="서류 불합격";
		}
		map.put("n_title", n_title);
		map.put("n_content", n_content);
		return dao.companyApplicationSendNote(map);
	}

}
