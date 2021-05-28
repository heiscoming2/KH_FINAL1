package com.itpro.model.dto.note;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoteDto {
	private int m_no;//회원번호
	private int n_no;//쪽지 번호
	private String n_send;//보낸사람
	private String n_receiver;//받는사람
	private String n_content;//내용
	private Date n_date;//발신일
	
	
	
	
	
}
