package com.itpro.model.dto.member;

import java.util.Date;

public class MemberDto {
	//회원 입력사항
	private int m_no;//회원번호
	private String m_id;//아이디
	private String m_pw;//비밀번호
	private String m_nickname;//닉네임
	private String m_phone;//전화번호
	private String m_email;//이메일
	private String m_name;//이름
	private Date m_birth;//생년월일
	private String m_gender;//성별
	private String m_addr;//주소	
	//인증,권한
	private char m_used;//탈퇴여부(탈퇴Y,회원N)
	private String m_act;//활동여부(활동, 정지)
	private char m_mail_cert;//메일 인증(미인증N,인증Y)
	private String m_type;//회원타입(개인회원, 기업회원, 관리자)
	private char auth;//권한(N회원Y관리자)
	//기업회원 필드
	private int m_regno;//사업자 번호
	private char m_admin_cert;//관리자 인증
	//이미지
	private String m_img_path;
	private Date m_regdate;	
	
	
	
	
}
