package com.itpro.model.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.note.NoteDto;
import com.itpro.model.dto.resume.ResumeDto;

public interface NoteDao {
	String NAMESPACE = "Note.";

	// 내가 받은 쪽지 목록 조회
	public List<NoteDto> receiveList(int n_receiver);
	
	// 보낸쪽지 목록
    public List<NoteDto> sendList(int n_sender);
			
	// 새로 받은 쪽지가 있는지 확인(매번)
	public Integer countNewNote();
	
	// 내가 받은쪽지 하나 읽기
    public NoteDto receiveDetail();	  
    
    // 읽은 쪽지 읽은 시간 표시 UPDATE 
    public int updateReadDate();    
    
    // 보낸 쪽지 하나 읽기 
    public NoteDto sendDetail();
    
    //쪽지 보내기
    public int noteSend(NoteDto noteDto);
	
	
}
