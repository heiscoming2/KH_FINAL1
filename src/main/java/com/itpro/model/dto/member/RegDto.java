package com.itpro.model.dto.member;

import java.util.Date;

public class RegDto {//일반회원 회원가입
	private int m_no; //회원번호
	private String m_id;//아이디
	private String m_pw;//비밀번호
	private String m_nickname;//닉네임,기업명
	private String m_phone;//전화번호
	private String m_email;//이메일
	private String m_used;//탈퇴여부
	private String m_act;//활동여부
	private String m_mail_cert;//메일인증
	private String m_type;//회원타입
	private String m_auth;//권한
	private Date m_regdate;//등록일
	
	public RegDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegDto(int m_no, String m_id, String m_pw, String m_nickname, String m_phone, String m_email, String m_used,
			String m_act, String m_mail_cert, String m_type, String m_auth, Date m_regdate) {
		super();
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_nickname = m_nickname;
		this.m_phone = m_phone;
		this.m_email = m_email;
		this.m_used = m_used;
		this.m_act = m_act;
		this.m_mail_cert = m_mail_cert;
		this.m_type = m_type;
		this.m_auth = m_auth;
		this.m_regdate = m_regdate;
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

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_used() {
		return m_used;
	}

	public void setM_used(String m_used) {
		this.m_used = m_used;
	}

	public String getM_act() {
		return m_act;
	}

	public void setM_act(String m_act) {
		this.m_act = m_act;
	}

	public String getM_mail_cert() {
		return m_mail_cert;
	}

	public void setM_mail_cert(String m_mail_cert) {
		this.m_mail_cert = m_mail_cert;
	}

	public String getM_type() {
		return m_type;
	}

	public void setM_type(String m_type) {
		this.m_type = m_type;
	}

	public String getM_auth() {
		return m_auth;
	}

	public void setM_auth(String m_auth) {
		this.m_auth = m_auth;
	}

	public Date getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(Date m_regdate) {
		this.m_regdate = m_regdate;
	}
	
	

	
	
	
}
