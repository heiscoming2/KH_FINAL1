package com.itpro.model.dto.note;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoteDto {
	private int n_no;//쪽지 번호
	private int n_sender;//보낸사람회원번호
	private int n_receiver;//받는사람 회원번호
	private String n_title;//쪽지 제목
	private String n_content;//내용
	private Date n_sendDate;//보낸 시간
	private Date n_readDate; //읽은 시간	
	
	// member
	private String m_nickname; // 닉네임
	
	// noteSend
	private String n_receiver_nickname; // 받는사람 닉네임
	
}

