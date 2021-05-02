package com.itpro.model.dto;

import java.util.Date;

public class MemberDto {
	//회원 필드
	private int m_no;//회원번호
	private String m_id;//아이디
	private String m_pw;//비밀번호
	private String name;//이름(닉네임, 회사명)
	private String m_email;//이메일
	private char m_used;//탈퇴여부(탈퇴Y,회원N)
	private String m_act;//활동여부(활동, 정지)
	private char m_mail_cert;//메일 인증(미인증N,인증Y)
	private String m_type;//회원타입(개인회원, 기업회원, 관리자)
	private char auth;//권한(N회원Y관리자)
	private String m_img_path;
	private Date m_regdate;
	//기업회원 필드
	private int m_regno;//사업자 번호
	private char m_admin_cert;//관리자 인증
	
	public MemberDto() {
		super();
	}

	public MemberDto(int m_no, String m_id, String m_pw, String name, String m_email, char m_used, String m_act,
			char m_mail_cert, String m_type, char auth, String m_img_path, Date m_regdate, int m_regno,
			char m_admin_cert) {
		super();
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.name = name;
		this.m_email = m_email;
		this.m_used = m_used;
		this.m_act = m_act;
		this.m_mail_cert = m_mail_cert;
		this.m_type = m_type;
		this.auth = auth;
		this.m_img_path = m_img_path;
		this.m_regdate = m_regdate;
		this.m_regno = m_regno;
		this.m_admin_cert = m_admin_cert;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public char getM_used() {
		return m_used;
	}

	public void setM_used(char m_used) {
		this.m_used = m_used;
	}

	public String getM_act() {
		return m_act;
	}

	public void setM_act(String m_act) {
		this.m_act = m_act;
	}

	public char getM_mail_cert() {
		return m_mail_cert;
	}

	public void setM_mail_cert(char m_mail_cert) {
		this.m_mail_cert = m_mail_cert;
	}

	public String getM_type() {
		return m_type;
	}

	public void setM_type(String m_type) {
		this.m_type = m_type;
	}

	public char getAuth() {
		return auth;
	}

	public void setAuth(char auth) {
		this.auth = auth;
	}

	public String getM_img_path() {
		return m_img_path;
	}

	public void setM_img_path(String m_img_path) {
		this.m_img_path = m_img_path;
	}

	public Date getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(Date m_regdate) {
		this.m_regdate = m_regdate;
	}

	public int getM_regno() {
		return m_regno;
	}

	public void setM_regno(int m_regno) {
		this.m_regno = m_regno;
	}

	public char getM_admin_cert() {
		return m_admin_cert;
	}

	public void setM_admin_cert(char m_admin_cert) {
		this.m_admin_cert = m_admin_cert;
	}	
	
	
}
